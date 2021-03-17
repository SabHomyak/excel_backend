package excel.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineApplication.class, args);
    }

}
