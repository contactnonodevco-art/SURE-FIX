package com.surefix.mapper;

import com.surefix.dto.diagnostic.DiagnosticCreateDTO;
import com.surefix.dto.diagnostic.DiagnosticDTO;
import com.surefix.entity.Diagnostic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper Diagnostic - Conversion automatique Entity ↔ DTO
 * Nécessite des mappings explicites pour les relations
 */
@Mapper(componentModel = "spring")
public interface DiagnosticMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userName")
    @Mapping(source = "shop.id", target = "shopId")
    @Mapping(source = "shop.name", target = "shopName")
    @Mapping(source = "appliance.id", target = "applianceId")
    @Mapping(source = "appliance.modelNumber", target = "applianceModel")
    @Mapping(source = "errorCode.id", target = "errorCodeId")
    @Mapping(target = "errorCode", expression = "java(diagnostic.getErrorCode() != null ? diagnostic.getErrorCode().getCode() : null)")
    DiagnosticDTO toDto(Diagnostic diagnostic);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "shop", ignore = true)
    @Mapping(target = "appliance", ignore = true)
    @Mapping(target = "errorCode", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "aiResponse", ignore = true)
    @Mapping(target = "recommendedParts", ignore = true)
    @Mapping(target = "repairSteps", ignore = true)
    @Mapping(target = "processingTimeMs", ignore = true)
    @Mapping(target = "aiModel", ignore = true)
    @Mapping(target = "extractedErrorCode", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Diagnostic toEntity(DiagnosticCreateDTO dto);
}
