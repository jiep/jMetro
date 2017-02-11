package com.aebd.jMetro;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aebd.jMetro.metro.Metro;

@SpringBootApplication
public class Application {
	
	private Metro m = Metro.getInstance();


    @RequestMapping("/")
    public String home() {
        return Arrays.toString(m.getNombreEstaciones());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
