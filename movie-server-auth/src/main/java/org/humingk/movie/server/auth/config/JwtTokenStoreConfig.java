package org.humingk.movie.server.auth.config;

import org.humingk.movie.server.auth.config.MyJwtTokenEnhancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 通过JWT存储token
 *
 * @author humingk
 */
@Configuration
public class JwtTokenStoreConfig {

    /**
     * 注册 JWT-签名设置秘钥
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        // 配置JWT使用的秘钥,对称加密
        accessTokenConverter.setSigningKey("youaretheappleofmyeyes");
        return accessTokenConverter;
    }

    /**
     * 注册 JWT-存储token
     *
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 注册 JWT-自定义JWT
     *
     * @return
     */
    @Bean
    public MyJwtTokenEnhancer jwtTokenEnhancer() {
        return new MyJwtTokenEnhancer();
    }

}
