package com.pribas.pribasmonolithic.mapper;

import com.pribas.pribasmonolithic.dto.request.UserRequestDto;
import com.pribas.pribasmonolithic.dto.response.UserResponseDto;
import com.pribas.pribasmonolithic.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper (componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

User toUser(UserResponseDto userResponseDto);
User toUser(UserRequestDto userRequestDto);
UserResponseDto toUserResponseDto (User user);
UserRequestDto toUserRequestDto (User user);


}
