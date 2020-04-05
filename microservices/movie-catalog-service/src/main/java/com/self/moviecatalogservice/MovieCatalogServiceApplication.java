package com.self.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableEurekaClient
@EnableHystrix //uses proxy class concept-Read on internet
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	@Bean
	@LoadBalanced /*Service Discovery, Load Balancing-If multiple instances are running of same microservice it picks one by itself (Though it is not
	an effective load balancing). Load balancing also maintains a cache in case discovery server goes down and there is no response from it.
	Then, it looks the address from cache.
	In case if any micro service goes down, the Eureka server has a concept of 'Heart Beats' i.e. it regularly pings microservices to check if they
	are still alive. All this happens internally without us writing a single line of code.
	*/
	public RestTemplate getRestTemplateInstance() {
		/*
		Putting timeout the simpler way but not a preferred way.
		 */
//		HttpComponentsClientHttpRequestFactory componentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		componentsClientHttpRequestFactory.setConnectTimeout(3000);
//		return new RestTemplate(componentsClientHttpRequestFactory);


		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilderInstance() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
