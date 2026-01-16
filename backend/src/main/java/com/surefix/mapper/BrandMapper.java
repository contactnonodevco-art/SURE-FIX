package com.surefix.mapper;

import com.surefix.dto.brand.BrandCreateDTO;
import com.surefix.dto.brand.BrandDTO;
import com.surefix.entity.Brand;
import org.mapstruct.Mapper;

/**
 * Mapper Brand - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTO toDto(Brand brand);

    Brand toEntity(BrandCreateDTO dto);
}
