package com.usa.federal.gov.ssa.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
/**
 * This annnotation is for configure properties with prefix. prefix is root element
 * @author Krishna Murari
 *
 */
@ConfigurationProperties(prefix="app")
@Data
public class AppConfig {
	/**
	 * Storeing all String messages in Map with same varible name as in yml that is properties
	 */
	Map<String,String> properties=new HashMap<String, String>();

}
