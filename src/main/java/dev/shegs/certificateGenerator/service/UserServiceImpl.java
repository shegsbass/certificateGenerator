package dev.shegs.certificateGenerator.service;

import dev.shegs.certificateGenerator.entity.User;
import dev.shegs.certificateGenerator.repository.UserRepository;
import dev.shegs.certificateGenerator.config.DBOperationRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private DBOperationRunner dbOperationRunner;

    @Override
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public Boolean emailExist(String email) {
        User user = repository.findUserByEmail(email);
        return user != null;
    }

}
