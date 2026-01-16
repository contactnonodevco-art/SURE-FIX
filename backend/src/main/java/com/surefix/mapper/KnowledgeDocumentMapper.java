package com.surefix.mapper;

import com.surefix.dto.knowledge.KnowledgeDocumentCreateDTO;
import com.surefix.dto.knowledge.KnowledgeDocumentDTO;
import com.surefix.entity.KnowledgeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper KnowledgeDocument - Conversion automatique Entity ↔ DTO
 */
@Mapper(componentModel = "spring")
public interface KnowledgeDocumentMapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "uploadedBy.id", target = "uploadedById")
    @Mapping(source = "uploadedBy.firstName", target = "uploadedByName")
    KnowledgeDocumentDTO toDto(KnowledgeDocument document);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "extractedContent", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uploadedBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    KnowledgeDocument toEntity(KnowledgeDocumentCreateDTO dto);
}
