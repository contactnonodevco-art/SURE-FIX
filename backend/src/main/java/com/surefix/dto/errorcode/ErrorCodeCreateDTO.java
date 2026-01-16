package com.surefix.dto.errorcode;

import com.surefix.enums.ApplianceType;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un code d'erreur
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorCodeCreateDTO {

    /** Code d'erreur (ex: F21, E3) */
    @NotBlank(message = "Le code d'erreur est obligatoire")
    private String code;

    /** ID de la marque */
    @NotNull(message = "La marque est obligatoire")
    private Integer brandId;

    /** Type d'appareil concerné */
    @NotNull(message = "Le type d'appareil est obligatoire")
    private ApplianceType applianceType;

    /** Description courte du problème */
    @NotBlank(message = "La description courte est obligatoire")
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
    @Min(value = 1, message = "Le niveau de difficulté minimum est 1")
    @Max(value = 5, message = "Le niveau de difficulté maximum est 5")
    private Integer difficultyLevel;

    /** Temps estimé de réparation en minutes */
    private Integer estimatedRepairTime;
}
