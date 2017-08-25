package org.food.safety.trace.service;

import lombok.Getter;
import org.food.safety.trace.dto.ListFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
public class CURDServiceImpl implements CURDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CURDServiceImpl.class);

    @Override
    public List list(String name, ListFilter listFilter) {
        return null;
    }
}
