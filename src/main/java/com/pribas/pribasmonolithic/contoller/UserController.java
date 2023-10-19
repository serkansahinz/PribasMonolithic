package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.UserRequestDto;
import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.model.User;
import com.pribas.pribasmonolithic.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserController {

    public final UserService userService;


    @GetMapping("/")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.createUser(userRequestDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable String id, @RequestBody @Valid UserRequestDto userRequestDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.updateUser(id, userRequestDto));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) throws ResourceNotFoundException {
        return userService.deleteUser(id);
    }


}
