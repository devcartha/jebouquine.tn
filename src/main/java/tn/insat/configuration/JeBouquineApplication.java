package tn.insat.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class JeBouquineApplication {

    @Bean
    @ConfigurationProperties(prefix="datasource.hikari")
    public HikariDataSource dataSource() {
        return new HikariDataSource();
    }

    public static void main(String[] args) {
        SpringApplication.run(JeBouquineApplication.class, args);
    }
}
