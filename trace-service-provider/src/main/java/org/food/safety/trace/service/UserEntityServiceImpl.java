package org.food.safety.trace.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.food.safety.trace.dto.ListFilter;
import org.food.safety.trace.dto.PageSearch;
import org.food.safety.trace.dto.Viewable;
import org.food.safety.trace.repository.Dao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * User: tom
 * Date: 2017/8/25
 */
@Service
@Getter
@Slf4j
public class UserEntityServiceImpl extends CURDServiceImpl {

}
