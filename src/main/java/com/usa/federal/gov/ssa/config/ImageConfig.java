package com.usa.federal.gov.ssa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class ImageConfig {

	@Bean
	public StandardServletMultipartResolver createMP() {
		return new StandardServletMultipartResolver();
	}
}
