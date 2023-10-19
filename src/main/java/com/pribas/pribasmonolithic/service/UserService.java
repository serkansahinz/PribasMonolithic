package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.request.UserRequestDto;
import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.exception.ResourceNotFoundException;
import com.pribas.pribasmonolithic.mapper.IUserMapper;
import com.pribas.pribasmonolithic.model.User;
import com.pribas.pribasmonolithic.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final IUserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        User user = IUserMapper.INSTANCE.toUser(userRequestDto);
       userRepository.save(user);
       return IUserMapper.INSTANCE.toUserResponseDto(user);
    }

    public UserResponseDto updateUser(String id, UserRequestDto userRequestDto) throws ResourceNotFoundException {
        User user = userRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User not found ID : " + id));

        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        userRepository.save(user);

        return IUserMapper.INSTANCE.toUserResponseDto(user);

    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String id) throws ResourceNotFoundException {
          User user = userRepository.findById(id).
                orElseThrow( ()-> new ResourceNotFoundException("USER NOT FOUND id:" + id));
        return user;
    }

    public String deleteUser(String id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).
                orElseThrow( ()-> new ResourceNotFoundException("USER NOT FOUND id:" + id));

        userRepository.deleteById(id);
        return id + " id numbered user has been deleted";
    }
}
