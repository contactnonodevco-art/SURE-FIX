package com.surefix.repository;

import com.surefix.entity.KnowledgeDocument;
import com.surefix.enums.ApplianceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité KnowledgeDocument (Document technique)
 */
@Repository
public interface KnowledgeDocumentRepository extends JpaRepository<KnowledgeDocument, Integer> {

    /** Recherche par titre */
    Optional<KnowledgeDocument> findByTitle(String title);

    /** Recherche par marque */
    List<KnowledgeDocument> findByBrandId(Integer brandId);

    /** Recherche par type d'appareil */
    List<KnowledgeDocument> findByApplianceType(ApplianceType applianceType);

    /** Recherche par marque et type d'appareil */
    List<KnowledgeDocument> findByBrandIdAndApplianceType(Integer brandId, ApplianceType applianceType);

    /** Recherche les documents actifs */
    List<KnowledgeDocument> findByActive(Boolean active);

    /** Recherche par marque et actif */
    List<KnowledgeDocument> findByBrandIdAndActive(Integer brandId, Boolean active);

    /** Recherche par utilisateur qui a uploadé */
    List<KnowledgeDocument> findByUploadedById(Integer userId);
}
