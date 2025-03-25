package com.ashu.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

	@Bean
	public RouteLocator bankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(path -> path.path("/bank/accounts/**")
						.filters(filter -> filter.rewritePath("/bank/accounts/(?<segment>.*)", "/${segment}"))
						.uri("lb://ACCOUNTS"))
				.route(path -> path.path("/bank/loans/**")
						.filters(filter -> filter.rewritePath("/bank/loans/(?<segment>.*)", "/${segment}"))
						.uri("lb://LOANS"))
				.route(path -> path.path("/bank/cards/**")
						.filters(filter -> filter.rewritePath("/bank/cards/(?<segment>.*)", "/${segment}"))
						.uri("lb://CARDS"))
				.build();
	}

}
