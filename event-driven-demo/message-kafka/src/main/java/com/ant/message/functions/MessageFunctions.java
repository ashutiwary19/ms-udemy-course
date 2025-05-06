package com.ant.message.functions;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ant.message.dto.AccountsMsgDto;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MessageFunctions {
	
	@Bean
	Function<Object, Object> initCommunication() {
		return packet -> {
			log.info("Sending init with details : " + packet.toString());
			return packet;
		};
	}

	@Bean
	public Function<AccountsMsgDto,AccountsMsgDto> email() {
		return accountsMsgDto -> {
			log.info("Sending EMAIL with details : " + accountsMsgDto.toString());
			return accountsMsgDto;
		};
	}

	@Bean
	public Function<AccountsMsgDto, Long> sms() {
		return accountsMsgDto -> {
			log.info("Sending SMS with details : " + accountsMsgDto.toString());
			return accountsMsgDto.getAccountNumber();
		};
	}
}
