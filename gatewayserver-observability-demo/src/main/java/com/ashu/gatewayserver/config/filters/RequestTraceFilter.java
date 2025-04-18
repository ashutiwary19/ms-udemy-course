package com.ashu.gatewayserver.config.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

	private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

	@Autowired
	private FilterUtility filterUtility;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		if (filterUtility.isCorrelationIdPresent(exchange.getRequest().getHeaders())) {
			logger.error("Bank-correlation-id found in RequestTraceFilter : {}",
					filterUtility.getCorrelationId(exchange.getRequest().getHeaders()));
		} else {
			String correlationId = filterUtility.generateCorrelationId();
			exchange = filterUtility.setCorrelationId(exchange, correlationId);
			logger.error("Bank-correlation-id generated in RequestTraceFilter : {}", correlationId);

		}
		return chain.filter(exchange);
	}

}
