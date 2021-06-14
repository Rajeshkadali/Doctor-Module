package com.cg.bmd;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import  com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("Doctor-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
	private Predicate<String> postPaths()
	{
		return or(regex("/Doctors/.*"));
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder().title("Doctor API").description("Doctor API reference for developers")
				.termsOfServiceUrl("http://rajesh.com").license("Doctor License").licenseUrl("rajesh.kadali.rajesh12@gmail.com").version("1.0").build();
	}
}



