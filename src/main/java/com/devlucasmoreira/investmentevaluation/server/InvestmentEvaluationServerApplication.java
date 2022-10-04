package com.devlucasmoreira.investmentevaluation.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class InvestmentEvaluationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestmentEvaluationServerApplication.class, args);
    }

}
