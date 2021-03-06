package com.p5.adoptions.security;

import com.p5.adoptions.model.roles.RolesEnum;
import com.p5.adoptions.repository.roles.Role;
import com.p5.adoptions.repository.roles.RoleRepository;
import com.p5.adoptions.repository.users.User;
import com.p5.adoptions.repository.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passowrdEncoder;

    public MyUserDetailsService(UserRepository userRepository, RoleRepository role, BCryptPasswordEncoder passowrdEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = role;
        this.passowrdEncoder = passowrdEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);

        if (!userOptional.isPresent()) {
            throw  new UsernameNotFoundException(username);
        }

        return new UserPrincipal(userOptional.get());
    }

    // Initialize DB with a default user (only for test)
    @Bean
    private CommandLineRunner setDefaultUser() {
        return args -> {
            final String defaultEmail="animalshelter@pentastagiu.io";
            final String defaultPassword = "password";

            Role moderatorRole = roleRepository.findByRole(RolesEnum.ROLE_MOD).orElseGet(() -> {
                Role newRole = new Role().setRole(RolesEnum.ROLE_MOD);
                return roleRepository.save(newRole);
            });

            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);

            if (!defaultUser.isPresent()) {
                userRepository.save(new User()
                                    .setEmail(defaultEmail)
                                    .setPassword(passowrdEncoder.encode(defaultPassword)))
                                    .setUserRoles(Collections.singleton(moderatorRole));
            }
        };
    }
}
