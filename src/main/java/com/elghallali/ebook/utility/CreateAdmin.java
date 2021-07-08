package com.elghallali.ebook.utility;

import java.util.HashSet;
import java.util.Set;

import com.elghallali.ebook.model.User;
import com.elghallali.ebook.model.security.Role;
import com.elghallali.ebook.model.security.UserRole;
import com.elghallali.ebook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//**/import org.springframework.stereotype.Component;

//**/@Component
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
        user1.setEmail("y.elghallali@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(0);
        role1.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);

    }

}
