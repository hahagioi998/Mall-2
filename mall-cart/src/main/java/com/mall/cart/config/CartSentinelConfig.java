package com.mall.cart.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.mall.common.exception.BizCodeEnum;
import com.mall.common.utils.R;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 购物车模块服务降级熔断配置类
 * @author littlecheung
 */
@Configuration
public class CartSentinelConfig {

    public CartSentinelConfig() {

        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
            @Override
            public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
                R error = R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(), BizCodeEnum.TO_MANY_REQUEST.getMsg());
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(JSON.toJSONString(error));
            }
        });

    }

}