package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class UserEntityServiceImpl extends CURDServiceImpl {
    /**
     *
     * @param data
     * @return
     */
    public boolean login(Map data){
        log.debug("login:{}", data);
        return true;
    }
}
