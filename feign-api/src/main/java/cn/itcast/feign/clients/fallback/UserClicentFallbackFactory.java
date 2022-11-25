package cn.itcast.feign.clients.fallback;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Description ==> TODO
 * BelongsProject ==> cloud-demo
 * BelongsPackage ==> cn.itcast.feign.clients.fallback
 * Version ==> 1.0
 * CreateTime ==> 2022-11-25 15:17:14
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Slf4j
public class UserClicentFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {

        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.error("查询用户异常!!!",throwable);
                return new User();
            }
        };
    }
}
