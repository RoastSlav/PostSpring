package rostislav.postspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("rostislav/postspring/mappers")
public class PostSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostSpringApplication.class, args);
    }

}
