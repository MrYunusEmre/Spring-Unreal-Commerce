package com.akturkpasaj.User.Management.System.service;

import com.akturkpasaj.User.Management.System.dto.UserAuthentication;
import com.akturkpasaj.User.Management.System.model.User;
import com.akturkpasaj.User.Management.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(""+id));
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public User authenticateUser(UserAuthentication userAuthentication){
        return userRepository.findByEmailAndPassword(userAuthentication.getUsername(), userAuthentication.getPassword());
    }

}
