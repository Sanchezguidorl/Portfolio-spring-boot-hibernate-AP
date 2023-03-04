
package com.portfolio.GuidoSanchez.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@EnableWebMvc
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    
    
//configuración de cors
    
           @Override
            public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/login")
            .allowedOrigins("*")
            .allowedMethods("OPTIONS","POST")
            .allowedHeaders("*")
            .exposedHeaders("Access-Control-Allow-Origin","Authorization");
               
               registry.addMapping("/**")
                       .allowedOrigins("*")
                       .allowedMethods("*");
                    
           }
}
