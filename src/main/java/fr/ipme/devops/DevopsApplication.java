package fr.ipme.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevopsApplication {

	public static void main(String[] args) {
		System.out.println("Coucou, on lance le premier projet SB !");
		SpringApplication.run(DevopsApplication.class, args);
	}

}
