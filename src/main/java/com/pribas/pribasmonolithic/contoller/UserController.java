package com.pribas.pribasmonolithic.contoller;

import com.pribas.pribasmonolithic.dto.request.UserRequestDto;
import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.model.User;
import com.pribas.pribasmonolithic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.pribas.pribasmonolithic.constant.RestApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERS)
public class UserController {

    public final UserService userService;


    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/find_user_by_id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/create_user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.createUser(userRequestDto));

    }
    @PutMapping("/update_user")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.updateUserByName(userRequestDto));
    }

    @DeleteMapping("/delete_user_by_id/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }


}
