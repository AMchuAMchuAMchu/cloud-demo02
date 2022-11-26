package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Description ==> TODO
 * BelongsProject ==> cloud-demo
 * BelongsPackage ==> cn.itcast.order.sentinel.impl
 * Version ==> 1.0
 * CreateTime ==> 2022-11-26 11:27:55
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Component
public class HeaderParseOrigin implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String origin = httpServletRequest.getHeader("origin");
        if (StringUtils.isEmpty(origin)) {
            return "blank!!";
        }
        return origin;
    }
}
