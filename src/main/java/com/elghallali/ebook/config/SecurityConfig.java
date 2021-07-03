package com.elghallali.ebook.config;

import com.elghallali.ebook.service.impl.UserSecurityService;
import com.elghallali.ebook.utility.SecurityUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // private Environment environment;

    @Autowired
    private UserSecurityService userSecurityService;

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/img/**", "/", "/auth/**", "/fonts/**",
            "/demo/**", "/bookshelf", "/bookDetail/**", "/hours", "/faq", "/searchByCategory", "/searchBook", "/",
            "/direction", "/error"

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.csrf().disable().cors().disable().formLogin().failureUrl("/auth/login?error").defaultSuccessUrl("/")
                .loginPage("/auth/login").permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/?logout")
                .deleteCookies("remember-me").permitAll().and().rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }

}
