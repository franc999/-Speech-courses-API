package com.manuels.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ManuelsLocucionApplication {
        
    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello heroku!";
    }
    
	public static void main(String[] args) {
		SpringApplication.run(ManuelsLocucionApplication.class, args);
	}
}