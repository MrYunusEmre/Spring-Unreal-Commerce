package com.akturkpasaj.User.Management.System.controller;

import com.akturkpasaj.User.Management.System.dto.UserAuthentication;
import com.akturkpasaj.User.Management.System.model.User;
import com.akturkpasaj.User.Management.System.service.TokenService;
import com.akturkpasaj.User.Management.System.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceController.class);

    private final TokenService tokenService;

    @Autowired
    private final UserService userService;

    public ResourceController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

//    @RequestMapping("/login")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<String> authenticateUser(@RequestBody UserAuthentication userAuthentication){
//        User user = userService.authenticateUser(userAuthentication);
//        return ResponseEntity.ok(user.toString());
//    }

    @PostMapping("/login")
    public String token(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }
}
