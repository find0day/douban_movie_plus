package org.humingk.movie.api.user;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.IOException;


/**
 * 用户登录API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface LoginApi {
    /**
     * auth 登录
     *
     * @param email    用户邮箱
     * @param password 密码
     * @return
     */
    @PostMapping("login")
    Result login(@RequestParam("username") @Email String email,
                 @RequestParam("password") @NotBlank String password);

    /**
     * github 第三方登录
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/github_login")
    void githubLogin(HttpServletResponse response) throws IOException;

    /**
     * github 第三方登录 回调方法
     *
     * @param code  授权码（授权码模式）
     * @param state github_login传入的state
     * @return
     */
    @GetMapping("/github_callback")
    Result githubCallback(@RequestParam("code") String code,
                          @RequestParam("state") String state);

}
