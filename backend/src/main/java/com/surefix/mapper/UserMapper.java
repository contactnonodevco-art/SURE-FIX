package com.surefix.mapper;

import com.surefix.dto.user.UserCreateDTO;
import com.surefix.dto.user.UserDTO;
import com.surefix.entity.User;
import org.mapstruct.Mapper;

/**
 * Mapper User - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserCreateDTO dto);
}
