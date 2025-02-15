package com.SookmyungIT.Pricedive.controller;

import com.SookmyungIT.Pricedive.dto.UserRequestDTO;
import com.SookmyungIT.Pricedive.model.User;
import com.SookmyungIT.Pricedive.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "사용자 관리 API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 새로운 사용자 추가 API
     */
    @Operation(summary = "새로운 사용자 추가", description = "이메일, 비밀번호, 이름을 입력하여 사용자를 생성합니다.")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequest) {
        try {
            User newUser = userService.createUser(
                    userRequest.getEmail(),
                    userRequest.getPw(),
                    userRequest.getName()
            );

            return ResponseEntity.ok(newUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}