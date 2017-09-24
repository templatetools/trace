package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authc.AuthenticationException;
import org.food.safety.trace.entity.UserEntity;
import org.food.safety.trace.repository.Dao;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class UserServiceImpl extends CURDServiceImpl {

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

        return userEntity.getId();
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

        return null;
    }
}
