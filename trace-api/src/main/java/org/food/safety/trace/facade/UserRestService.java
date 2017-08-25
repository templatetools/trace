package org.food.safety.trace.facade;

import org.food.safety.trace.converter.Converter;
import org.food.safety.trace.dto.UserDTO;
import org.food.safety.trace.entity.User;

/**
 * 用户信息 接口
 * <p>
 * Created by tom on 2017-03-07 13:25:01.
 */
 public interface UserRestService extends CURDRestService<UserDTO>,Converter<UserDTO, User> {

 }
