package com.pribas.pribasmonolithic.service;

import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.mapper.IUserMapper;
import com.pribas.pribasmonolithic.model.User;
import com.pribas.pribasmonolithic.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    public final IUserRepository userRepository;

    public UserResponseDto createUser(User user) {
       userRepository.save(user);
       return IUserMapper.INSTANCE.toUserResponseDto(user);
    }
}
