// package com.vai.user;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import jakarta.servlet.http.HttpServletResponse;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//         .csrf(csrf -> csrf.disable()) // Disable CSRF protection
//         .authorizeHttpRequests(authorize -> authorize
//             .requestMatchers("/api/users/login", "/api/users/register", "/api/users/**").permitAll() // Public endpoints
//             .anyRequest().authenticated() // Secure all other endpoints
//         )
//             .logout(logout -> logout
//                 .logoutUrl("/api/users/logout") // Specify the logout URL
//                 .logoutSuccessHandler((request, response, authentication) -> {
//                     response.setStatus(HttpServletResponse.SC_OK);
//                     response.getWriter().write("{\"message\": \"Logout successful\"}");
//                 })
//                 .deleteCookies("JSESSIONID") // Delete session cookie
//                 .invalidateHttpSession(true) // Invalidate the session
//                 .permitAll()
//             )
//             .sessionManagement(session -> session
//                 .maximumSessions(1) // Allow only one session per user
//                 .maxSessionsPreventsLogin(true) // Prevent new login if maximum sessions reached
//             );

//         return http.build();
//     }
// }
