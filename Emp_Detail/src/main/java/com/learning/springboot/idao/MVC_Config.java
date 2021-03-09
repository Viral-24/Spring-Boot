package com.learning.springboot.idao;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVC_Config implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 	Path uploadDir = Paths.get("./product-image/");
	        String imageuploadPath = uploadDir.toFile().getAbsolutePath();
	        
	        registry.addResourceHandler("/product-image/**").addResourceLocations("file:/"+imageuploadPath+"/");	
	}

	
}
