package com.bxuan.filters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: BXuan
 * @Date: 2023/03/19/ 1:16
 * @description 统一鉴权
 */

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //统一鉴权
    /**
     * 执行过滤器中的业务逻辑
     *    对请求参数中的access-token进行判断
     *       如果存在此参数:代表已经认证成功
     *       如果不存在此参数 : 认证失败.
     * ServerWebExchange : 相当于请求和响应的上下文(zuul中的RequestContext)
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if(!StringUtils.equals("admin",token)) {
            //鉴权失败
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        //放行逻辑
        return chain.filter(exchange);
    }
    //标识当前过滤器的优先级，返回值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
