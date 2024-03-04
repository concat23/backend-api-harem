package com.dev.harem.controller;

import com.dev.harem.entity.Customer;
import com.dev.harem.entity.User;
import com.dev.harem.service.ICustomerService;
import com.dev.harem.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserController {
    private final IUserService iUserService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setId(iUserService.getUsers().size() + 1L);
        User newUser = this.iUserService.createUser(user);
        return ResponseEntity.created(getLocation(user.getId())).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(iUserService.getUsers());
    }

    private URI getLocation(Long id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
