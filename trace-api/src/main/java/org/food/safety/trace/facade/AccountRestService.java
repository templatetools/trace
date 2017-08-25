package org.food.safety.trace.facade;

import org.food.safety.trace.dto.RestResult;
import org.food.safety.trace.dto.SignInDTO;
import org.food.safety.trace.dto.SignUpDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 账号
 *
 * @author tom
 */
public interface AccountRestService {
    /**
     * 注册
     */
    RestResult signUp(SignUpDTO signUp);

    /**
     * 登录
     */
    RestResult signIn(SignInDTO signIn, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出
     */
    RestResult signOut();

}
