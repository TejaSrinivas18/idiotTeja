package com.temple;

//import static com.google.common.base.Predicates.or;
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.google.common.base.Predicate;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//public class SwaggerConfig extends  WebMvcConfigurerAdapter{
//
//	
//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
//				.apiInfo(apiInfo()).select().paths(postPaths()).build();
//		}
//
//	private Predicate<String> postPaths() {
//		return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("JavaInUse API")
//				.description("JavaInUse API reference for developers")
//				.termsOfServiceUrl("http://javainuse.com")
//				.contact("javainuse@gmail.com").license("JavaInUse License")
//				.licenseUrl("javainuse@gmail.com").version("1.0").build();
//	}
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//	    registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
//	    registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
//	    registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
//	    registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/api/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
//	    registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//}
