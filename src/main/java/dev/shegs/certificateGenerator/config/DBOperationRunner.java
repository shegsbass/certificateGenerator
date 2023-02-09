package dev.shegs.certificateGenerator.config;

import dev.shegs.certificateGenerator.entity.User;
import dev.shegs.certificateGenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class DBOperationRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();

        user1.setFullName("Oladokun Oluwasegun");
        user1.setEmail("oluwasegun@shegs.io");
        userRepository.save(user1);

        User user2 = new User();

        user2.setFullName("Dami Oluwasegun");
        user2.setEmail("drey@shegs.io");
        userRepository.save(user2);

        User user3 = new User();

        user3.setFullName("Sols Concept");
        user3.setEmail("sols@shegs.io");
        userRepository.save(user3);
    }
}
