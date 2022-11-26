package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description ==> TODO
 * BelongsProject ==> cloud-demo
 * BelongsPackage ==> cn.itcast.order.sentinel
 * Version ==> 1.0
 * CreateTime ==> 2022-11-26 11:49:14
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Component
public class SentinelBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg = "果咩捏~~ 未知异常! Now System error!!";
        int status = 429;
        if (e instanceof FlowException){
            msg = "请求被限流了!!";
        }else if (e instanceof DegradeException){
            msg = "请求被降级了!!";
        }else if (e instanceof ParamFlowException){
            msg = "热点参数被限流了!!";
        }else if (e instanceof AuthorityException){
            msg = "请求没有权限!!";
            status = 401;
        }

        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(status);
        httpServletResponse.getWriter().println("<h1>🎃🎃错误状态码:"+status+"||错误信息:"+msg+"</h1>");

    }
}
