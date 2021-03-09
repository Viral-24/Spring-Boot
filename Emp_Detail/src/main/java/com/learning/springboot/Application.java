package com.learning.springboot;


import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.springboot.controller.Admin_Controller;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new File(Admin_Controller.uploadDirectory).mkdir();
		SpringApplication.run(Application.class, args);
	}

}
