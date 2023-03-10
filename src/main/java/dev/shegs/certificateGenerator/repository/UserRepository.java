package dev.shegs.certificateGenerator.repository;

import dev.shegs.certificateGenerator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findUserByEmail (String email);
}
