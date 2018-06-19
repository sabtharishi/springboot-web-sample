package com.rishi.practice.sample.web;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootWebSampleApplication {

    
    Logger log = LoggerFactory.getLogger(SpringbootWebSampleApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebSampleApplication.class, args);
	}
	
	@GetMapping(value = {"/logs", "/logs/{lines}" })
	public String printog(@PathVariable(name="lines",required=false) Integer logcount) {
	    if (logcount == null ) {
	        logcount = 1000;
	    }
	    
	   IntStream.range(1, logcount).forEach(i -> {
	      log.info("Logging message from printlog method:{}" , i); 
//	      System.out.println("Logging message from printlog method:{}" );
	   });
	  
	   return "Completed";
	}
}
