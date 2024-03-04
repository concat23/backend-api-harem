package com.dev.harem.service.implementation;

import com.dev.harem.entity.Role;
import com.dev.harem.entity.User;
import com.dev.harem.repository.IRoleRepository;
import com.dev.harem.repository.IUserRepository;
import com.dev.harem.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    private final IRoleRepository iRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = iRoleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return iUserRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return iUserRepository.findAll();
    }
}
