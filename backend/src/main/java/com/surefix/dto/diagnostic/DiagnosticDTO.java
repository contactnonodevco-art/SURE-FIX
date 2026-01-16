package com.surefix.dto.diagnostic;

import com.surefix.enums.DiagnosticStatus;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un diagnostic
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticDTO {

    private Integer id;

    /** ID du technicien */
    private Integer userId;

    /** Nom du technicien */
    private String userName;

    /** ID de l'atelier */
    private Integer shopId;

    /** Nom de l'atelier */
    private String shopName;

    /** ID de l'appareil */
    private Integer applianceId;

    /** Modèle de l'appareil */
    private String applianceModel;

    /** ID du code d'erreur */
    private Integer errorCodeId;

    /** Code d'erreur */
    private String errorCode;

    /** Description du problème par le technicien */
    private String problemDescription;

    /** URL de l'image uploadée */
    private String imageUrl;

    /** Code erreur extrait de l'image par Vision IA */
    private String extractedErrorCode;

    /** Statut du diagnostic */
    private DiagnosticStatus status;

    /** Réponse générée par l'IA */
    private String aiResponse;

    /** Pièces recommandées */
    private String recommendedParts;

    /** Étapes de réparation */
    private String repairSteps;

    /** Temps de traitement en millisecondes */
    private Long processingTimeMs;

    /** Modèle IA utilisé */
    private String aiModel;

    /** Date de création */
    private LocalDateTime createdAt;
}
