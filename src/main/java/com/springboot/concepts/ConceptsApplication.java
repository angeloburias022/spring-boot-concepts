package com.springboot.concepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.springboot.concepts.config.HttpLoggingFilter;

@SpringBootApplication
public class ConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConceptsApplication.class, args);
	}

	/**
	 * to apply filtering on certain endpoints
	 * @return
	 */
	// @Bean
    // public FilterRegistrationBean<HttpLoggingFilter> loggingFilter() {
    //     FilterRegistrationBean<HttpLoggingFilter> registrationBean = new FilterRegistrationBean<>();
    //     HttpLoggingFilter httpLoggingFilter = new HttpLoggingFilter();

    //     // Set the URL patterns to apply the filter to (e.g., "/endpoint1/*", "/endpoint2/*")
    //     registrationBean.addUrlPatterns("/taxi/*", "/endpoint2/*");

    //     registrationBean.setFilter(httpLoggingFilter);
    //     return registrationBean;
    // }

}
