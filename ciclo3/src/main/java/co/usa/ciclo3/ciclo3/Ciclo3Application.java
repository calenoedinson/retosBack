package co.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.model"})
public class Ciclo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Ciclo3Application.class, args);
    }

}
