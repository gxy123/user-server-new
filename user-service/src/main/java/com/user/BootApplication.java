package com.user;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @version 1.0
 * @author:  guoxiaoyu
 * @date : 2018/11/13
 */
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@ComponentScan("com")
public class BootApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BootApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) {
    }
}