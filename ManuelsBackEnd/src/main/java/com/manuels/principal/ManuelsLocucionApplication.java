package com.manuels.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ManuelsLocucionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManuelsLocucionApplication.class, args);
	}
        
        @RequestMapping("/hello")
        public String hello(){
            return "HELLOO O OO  ";
        }
}