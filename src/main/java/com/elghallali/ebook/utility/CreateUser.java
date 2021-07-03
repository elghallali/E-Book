package com.elghallali.ebook.utility;

import java.util.HashSet;
import java.util.Set;

import com.elghallali.ebook.model.User;
import com.elghallali.ebook.model.security.Role;
import com.elghallali.ebook.model.security.UserRole;
import com.elghallali.ebook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Component
public class CreateUser implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("Yassine");
        user1.setLastName("EL GHALLALI");
        user1.setUsername("elghallali");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("opa"));
        user1.setEmail("yassine.elghallali@etu.uae.ac.ma");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
    }

}
