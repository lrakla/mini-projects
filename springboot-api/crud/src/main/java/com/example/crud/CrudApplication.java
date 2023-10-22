package com.example.crud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class CrudApplication /*extends SpringBootServletInitializer*/  {
	//  @Overrideclass
    // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    //     return application.sources(CrudApplication.class);
    // }
	public static void main(String[] args) /*throws Exception */ {
		SpringApplication.run(CrudApplication.class, args);
	}
	
}
