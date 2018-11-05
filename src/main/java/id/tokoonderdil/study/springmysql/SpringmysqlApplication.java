package id.tokoonderdil.study.springmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //Annotations, gabungan dari @Configuration, @EnableAutoConfiguration dan @ComponentScan
@EnableJpaAuditing
public class SpringmysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmysqlApplication.class, args);
    }
}
