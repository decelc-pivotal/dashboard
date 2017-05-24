package io.pivotal.landing;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    @Override 
    public void addResourceHandlers(final ResourceHandlerRegistry registry) 
    { 
    	registry.addResourceHandler("/*.js/**").addResourceLocations("/static/"); 
    	registry.addResourceHandler("/*.css/**").addResourceLocations("/static/"); 
    	}

}
