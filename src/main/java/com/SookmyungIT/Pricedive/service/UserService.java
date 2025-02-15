package com.SookmyungIT.Pricedive.service;

import com.SookmyungIT.Pricedive.model.User;
import com.SookmyungIT.Pricedive.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 새로운 유저 추가
     */
    @Transactional
    public User createUser(String email, String pw, String name) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPw(pw);
        newUser.setName(name);

        return userRepository.save(newUser);
    }
}