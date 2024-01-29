package com.sqisoft.peis_admin.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

/**
 * class name : WebConfig
 * class desc :
 *   브라우저의 URL을 직접 입력하는 경우
 *   해당 요청에 대해 server 에서는 /static/index.html 로 보내서 처리하겠다는 것으로
 *   스프링 부트 프로젝트 위에 SPA의 프레임워크의 라우터 기능을 사용하기 위해서 필요
 *
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		/* 정적 리소스 등록 */
		registry.addResourceHandler("/**", "/*/*").addResourceLocations("classpath:/static/").resourceChain(true)
				.addResolver(new PathResourceResolver() {
					@Override
					protected Resource getResource(String resourcePath, Resource location) throws IOException {
						Resource requestedResource = location.createRelative(resourcePath);
						return requestedResource.exists() && requestedResource.isReadable() ? requestedResource	: new ClassPathResource("/static/index.html");
					}
				});
	}
}
