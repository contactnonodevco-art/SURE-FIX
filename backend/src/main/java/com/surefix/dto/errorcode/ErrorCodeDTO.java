package com.surefix.dto.errorcode;

import com.surefix.enums.ApplianceType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un code d'erreur
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorCodeDTO {

    private Integer id;

    /** Code d'erreur (ex: F21, E3) */
    private String code;

    /** ID de la marque */
    private Integer brandId;

    /** Nom de la marque */
    private String brandName;

    /** Type d'appareil concerné */
    private ApplianceType applianceType;

    /** Description courte du problème */
    private String shortDescription;

    /** Description détaillée du problème */
    private String fullDescription;

    /** Causes possibles */
    private String possibleCauses;

    /** Étapes de diagnostic */
    private String diagnosticSteps;

    /** Pièces potentiellement défaillantes */
    private String potentialParts;

    /** Niveau de difficulté (1-5) */
    private Integer difficultyLevel;

    /** Temps estimé de réparation en minutes */
    private Integer estimatedRepairTime;

    /** Date de création */
    private LocalDateTime createdAt;
}
