package co.edu.uceva.facultadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "co.edu.uceva.facultadservice.domain.services")
public class FacultadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacultadServiceApplication.class, args);
    }

}
