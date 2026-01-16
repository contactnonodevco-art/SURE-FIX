package com.surefix.mapper;

import com.surefix.dto.diagnostic.DiagnosticFeedbackCreateDTO;
import com.surefix.dto.diagnostic.DiagnosticFeedbackDTO;
import com.surefix.entity.DiagnosticFeedback;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper DiagnosticFeedback - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface DiagnosticFeedbackMapper {

    @Mapping(source = "diagnostic.id", target = "diagnosticId")
    DiagnosticFeedbackDTO toDto(DiagnosticFeedback feedback);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "diagnostic", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    DiagnosticFeedback toEntity(DiagnosticFeedbackCreateDTO dto);
}
