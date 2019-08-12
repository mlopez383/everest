package com.rental.advertisements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RestController
public class AdvertisementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementsApplication.class, args);
	}

    @RequestMapping (value = "", method = RequestMethod.GET)
    public String sayhello(){
        return "<h1>Home Page</h1>";
    }
}
