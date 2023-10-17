package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.model.User;
import com.pribas.pribasmonolithic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MAINPAGE)
public class UserController {

    public final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/create_user")
    public ResponseEntity<UserResponseDto> createUser(User user){
        return ResponseEntity.ok(userService.createUser(user));

    }


}
