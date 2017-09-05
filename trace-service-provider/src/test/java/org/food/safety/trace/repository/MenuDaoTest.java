package org.food.safety.trace.repository;

import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.TestSmartApplication;
import org.food.safety.trace.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 菜单信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
@Slf4j
public class MenuDaoTest {
    @Autowired
    MenuDao menuDao;

    @Test
    @Rollback(false)
    public void create() {
        Menu menu = new Menu();
        menu.setName("首页");
        menu.setIcon("laptop");
        menu.setRoute("/dashboard");

        Menu root = menuDao.save(menu);

        menu = new Menu();
        menu.setName("用户管理");
        menu.setIcon("user");
        menu.setRoute("/rest/UserEntity");
        menu.setMpid(root.getId());

        menuDao.save(menu);

        menu = new Menu();
        menu.setName("菜单管理");
        menu.setIcon("list");
        menu.setRoute("/rest/Menu");
        menu.setMpid(root.getId());

        menuDao.save(menu);

        log.debug("menu:{}", menu);
    }
}
