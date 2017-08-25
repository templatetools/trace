package org.food.safety.trace.repository;

import org.food.safety.trace.TestSmartApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
public class DaoBaseTest {

//    @Autowired
//    private UserDao dao;
//
//    @Test
//    public void findAll() {
//        List<User> users = dao.findAllBy();
//
//        Assert.assertNotNull(users);
//
//        Assert.assertEquals(users.size(), 0);
//    }
}
