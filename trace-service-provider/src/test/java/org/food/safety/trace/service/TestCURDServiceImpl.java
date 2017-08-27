package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.TestSmartApplication;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.repository.DaoBase;
import org.hibernate.jpa.internal.metamodel.MetamodelImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

/**
 * User: tom
 * Date: 2017/8/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestSmartApplication.class)
@ComponentScan("org.food.safety.trace")
@EnableAutoConfiguration
@Slf4j
public class TestCURDServiceImpl{
    @Autowired
    CURDService curdService;
    @Test
    public void list(){
        List list = curdService.list("UserEntity", new ListFilter());
        log.debug("list:{}", list);
    }
}
