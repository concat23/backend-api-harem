package com.dev.harem.init;

import com.dev.harem.entity.Role;
import com.dev.harem.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {

    private final IRoleRepository iRoleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(1L,"111","ROLE_USER");
        Role roleAdmin = new Role(2L,"222","ROLE_ADMIN");
        iRoleRepository.saveAll(asList(roleUser,roleAdmin));
    }
}
