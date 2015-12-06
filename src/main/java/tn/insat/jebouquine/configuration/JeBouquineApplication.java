package tn.insat.jebouquine.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@EntityScan(basePackages = "tn.insat.jebouquine.data.entity")
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
