package cn.itcast.feign.config;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.clients.fallback.UserClicentFallbackFactory;
import cn.itcast.feign.pojo.User;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }


    @Bean
    public UserClicentFallbackFactory userClicentFallbackFactory(){
        return new UserClicentFallbackFactory();
    }

}
