package com.ktds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("msa")
//                .secret("1234")
//                .authorities("ROLE_USER")
//                .scopes("read","write")
//                .resourceIds("A-API")
//                .authorizedGrantTypes("client_credentials");

        clients.inMemory()
                .withClient("client1")
                .secret("client1_pass")
                .scopes("read", "write")
                .authorizedGrantTypes("authorization_code")
                .resourceIds("A-API")
                .accessTokenValiditySeconds(60*60*16)  	//16시간
                .refreshTokenValiditySeconds(60*60*20); 	//20시간
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("ktmns.jks"), "new1234!".toCharArray())
                .getKeyPair("ktmns", "new1234!".toCharArray());
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter())
                .reuseRefreshTokens(false);  //refreshToken 재사용 설정(true: 만료시간 동일, false: 재발급시마다 시간 갱신됨)
    }


    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
}
