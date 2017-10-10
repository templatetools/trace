package org.food.safety.trace.service;

import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.food.safety.trace.dto.MenuView;
import org.food.safety.trace.dto.RoleView;
import org.food.safety.trace.dto.Token;
import org.food.safety.trace.dto.UserEntityView;
import org.food.safety.trace.entity.Menu;
import org.food.safety.trace.entity.Reference;
import org.food.safety.trace.entity.Role;
import org.food.safety.trace.entity.UserEntity;
import org.food.safety.trace.repository.Dao;
import org.food.safety.trace.repository.MenuDao;
import org.food.safety.trace.repository.ReferenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

import static org.food.safety.trace.facade.RestService.TOKEN;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class UserServiceImpl extends CURDServiceImpl {
    @Autowired
    private ReferenceDao referenceDao;
    @Autowired
    private MenuDao menuDao;

    /**
     *
     * @param data
     * @return
     */
    public String login(Map data){
        log.debug("login:{}", data);

        Dao dao = getDAO("UserEntity");

        UserEntity userEntity = Dao.findOneByKeyAndValue(dao, "name", data.get("username"));

        if (null == userEntity){
            throw new AuthenticationException("用户不存在!");
        }

        if (!userEntity.getPassword().equals(data.get("password"))){
            throw new AuthenticationException("密码错误!");
        }

        return StringUtils.join(ImmutableList.of(userEntity.getOrganization(),userEntity.getId()), File.separator);
    }

    /**
     *
     * @param data
     * @return
     */
    public Map<String, Object> info(Map data){

        log.debug("info:{}", data);

        Map<String, Object> result = new HashedMap();

        Map<String, Object> permissions = new HashedMap();
        permissions.put("visit", new String[]{"ff8080815e5136b3015e5136cfd40013", "ff8080815e5136b3015e5136cfd40014", "ff8080815e5136b3015e5136cfd40015"});
        permissions.put("role", "admin");

        result.put("permissions", permissions);
        result.put("username", "admin");
        result.put("id", "id");

        String tokenStr = MapUtils.getString(data, TOKEN);

        if (StringUtils.isNotEmpty(tokenStr)){
            Token token = new Token(tokenStr);

            Dao<UserEntity, String> userDao = getDAO(UserEntityView.TARGET_NAME);
            UserEntity userEntity = userDao.findOne(token.getUserId());

            if (null != userEntity){
                result.put("username", userEntity.getName());
                result.put("id", userEntity.getId());
            }else{
                throw new RuntimeException("not fond user!");
            }


            //获取 角色信息
            List<Reference> roles = referenceDao.findByTargetNameAndSourceId(RoleView.TARGET_NAME, token.getUserId());
            Set<String> visit = new HashSet<>();

            for (Reference reference: roles) {
                Dao<Role, String> dao = getDAO(RoleView.TARGET_NAME);

                Role role = (Role) dao.findOne(reference.getTargetId());

                if (null != role) {
                    permissions.put("role", role.getName());

                    List<Reference> menus = referenceDao.findByTargetNameAndSourceId(MenuView.TARGET_NAME, role.getId());


                    for (Reference menu: menus) {
                        Menu m = menuDao.findOne(menu.getTargetId());
                        visit.add(menu.getTargetId());
                        visit.add(m.getMpid());
                    }

                }

            }
            permissions.put("visit",visit);

            return result;
        }

        return null;
    }
}
