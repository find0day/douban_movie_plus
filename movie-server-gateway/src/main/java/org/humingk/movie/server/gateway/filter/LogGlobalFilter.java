package org.humingk.movie.server.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 自定义全局过滤器
 *
 * @author humingk
 */
@Slf4j
@Component
public class LogGlobalFilter implements GlobalFilter, Ordered {
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    String url = request.getURI().getRawPath();
    List<String> ipList = request.getHeaders().get("X-Real-IP");

    // gateway拦截所有的请求，统一记录请求日志
    log.info(
        "ip={},real-ip={},url={},args={}",
        request.getRemoteAddress(),
        (ipList != null && !ipList.isEmpty()) ? ipList.get(0) : "0.0.0.0",
        request.getURI().getRawPath(),
        request.getQueryParams().toString());
    return chain.filter(exchange);
  }

  /**
   * 此过滤器的优先级别最高
   *
   * @return
   */
  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
