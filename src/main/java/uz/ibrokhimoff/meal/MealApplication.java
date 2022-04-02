package uz.ibrokhimoff.meal;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.ibrokhimoff.meal.domain.AuthUser;
import uz.ibrokhimoff.meal.enums.AuthRole;
import uz.ibrokhimoff.meal.enums.Department;
import uz.ibrokhimoff.meal.enums.Position;
import uz.ibrokhimoff.meal.enums.Status;
import uz.ibrokhimoff.meal.properties.OpenApiProperties;
import uz.ibrokhimoff.meal.properties.ServerProperties;
import uz.ibrokhimoff.meal.repository.AuthUserRepository;
import uz.ibrokhimoff.meal.telegrambot.TelegramBot;

@SpringBootApplication
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
@OpenAPIDefinition
@RequiredArgsConstructor
public class MealApplication {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MealApplication.class, args);
        TelegramBot telegramBot = context.getBean(TelegramBot.class);
        telegramBot.run();
    }


    //    @Bean
    CommandLineRunner runner() {
        return (args) -> {
            authUserRepository.deleteAll();
            String encode = passwordEncoder.encode("123");
            System.out.println("encode = " + encode);

            AuthUser admin = AuthUser.childBuilder()
                    .username("admin")
                    .password(encode)
                    .role(AuthRole.ADMIN)
                    .position(Position.CEO)
                    .status(Status.ACTIVE)
                    .department(Department.SELLS)
                    .fullName("adminov admin adminovich")
                    .phone("+998906543210")
                    .build();
            authUserRepository.save(admin);
        };
    }

}
