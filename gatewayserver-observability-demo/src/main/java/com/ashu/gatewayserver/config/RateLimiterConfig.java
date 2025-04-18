package com.ashu.gatewayserver.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@AutoConfigureBefore(value = RouteConfiguration.class)
@Configuration
public class RateLimiterConfig {

	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1, 1, 1);
	}

	@Bean
	public KeyResolver userKeyResolved() {
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}

}
