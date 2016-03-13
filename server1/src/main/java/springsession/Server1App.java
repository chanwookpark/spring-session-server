package springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author chanwook
 */
@SpringBootApplication
public class Server1App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Server1App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Server1App.class);
    }

}
