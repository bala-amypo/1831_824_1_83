// package com.example.demo.config;

// import com.example.demo.security.JwtAuthenticationFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// public class SecurityConfig {

//     private final JwtAuthenticationFilter jwtFilter;

//     public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
//         this.jwtFilter = jwtFilter;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http.csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                         "/auth/**",
//                         "/swagger-ui/**",
//                         "/v3/api-docs/**"
//                 ).permitAll()
//                 .requestMatchers("/api/**").authenticated()
//                 .anyRequest().permitAll()
//             )
//             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(
//             AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }
// }
SELECT id FROM slarequirement;
Make sure:

No duplicate IDs

IDs are numeric

Step 2️⃣ Alter the table (THIS IS THE FIX)
sql
Copy code
ALTER TABLE slarequirement
MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
✅ This adds auto-increment to id

Step 3️⃣ Reset auto increment (optional but recommended)
sql
Copy code
ALTER TABLE slarequirement AUTO_INCREMENT = 1;
(Next insert will use MAX(id) + 1 automatically)

Step 4️⃣ Verify
sql
Copy code
DESC slarequirement;
You should now see:

text
Copy code
id | bigint | NO | PRI | NULL | auto_increment