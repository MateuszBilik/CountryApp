package com.asap.country_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
//TODO
    // docker run -p 0.0.0.0:3306:3306 --name countryappdb -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=countryappdb -d mysql
}
