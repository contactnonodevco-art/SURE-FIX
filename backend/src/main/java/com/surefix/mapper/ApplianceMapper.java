package com.surefix.mapper;

import com.surefix.dto.appliance.ApplianceCreateDTO;
import com.surefix.dto.appliance.ApplianceDTO;
import com.surefix.entity.Appliance;
import org.mapstruct.Mapper;

/**
 * Mapper Appliance - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface ApplianceMapper {

    ApplianceDTO toDto(Appliance appliance);

    Appliance toEntity(ApplianceCreateDTO dto);
}
