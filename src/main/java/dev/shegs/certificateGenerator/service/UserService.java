package dev.shegs.certificateGenerator.service;

import dev.shegs.certificateGenerator.entity.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    public User findUserByEmail (String email);

    public Boolean emailExist (String  email);

}
