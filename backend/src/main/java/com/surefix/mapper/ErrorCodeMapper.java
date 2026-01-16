package com.surefix.mapper;

import com.surefix.dto.errorcode.ErrorCodeCreateDTO;
import com.surefix.dto.errorcode.ErrorCodeDTO;
import com.surefix.entity.ErrorCode;
import org.mapstruct.Mapper;

/**
 * Mapper ErrorCode - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface ErrorCodeMapper {

    ErrorCodeDTO toDto(ErrorCode errorCode);

    ErrorCode toEntity(ErrorCodeCreateDTO dto);
}
