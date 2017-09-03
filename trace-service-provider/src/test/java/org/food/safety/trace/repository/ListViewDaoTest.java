package org.food.safety.trace.repository;

import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.TestSmartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * 用户信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
@Slf4j
public class ListViewDaoTest {
    @Autowired
    ListViewDao listViewDao;

    @Test
    public void findByEntityNameLike() {
        List list = listViewDao.findByEntityNameLike("%UserEntity");
        log.debug("findByEntityNameLike:{}", list);
    }
}
