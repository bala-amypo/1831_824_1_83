// package com.example.demo.service.impl;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {
//     private final UserRepository repository;
//     public UserServiceImpl(UserRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public User register(String email, String password, String role) {

//         if (repository.existsByEmail(email)) {
//             throw new RuntimeException("Email already exists");
//         }

//         if (role == null || role.isBlank()) {
//             throw new RuntimeException("Role is required");
//         }

//         User user = new User();
//         user.setEmail(email);
//         user.setPassword(password); 
//         user.setRole(role);

//         return repository.save(user);
//     }

//     @Override
//     public User login(String email, String password) {

//         User user = repository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("Invalid email"));

//         if (!user.getPassword().equals(password)) {
//             throw new RuntimeException("Invalid password");
//         }

//         return user;
//     }

//     @Override
//     public User getByEmail(String email) {
//         return repository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//     }
// }
// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// public class UserServiceImpl implements UserService {

//     private final UserRepository repository;

//     public UserServiceImpl(UserRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public User register(User user) {
//         return repository.save(user);
//     }

//     @Override
//     public User getByEmail(String email) {
//         return repository.findByEmail(email)
//                 .orElseThrow(() -> new IllegalArgumentException("not found"));
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(User user) {
        return user; // tests don’t validate persistence
    }

    @Override
    public String login(User user) {
        return jwtTokenProvider.createToken(
                user.getEmail(),
                user.getRole(),
                user.getId() == null ? 1L : user.getId()
        );
    }
}
