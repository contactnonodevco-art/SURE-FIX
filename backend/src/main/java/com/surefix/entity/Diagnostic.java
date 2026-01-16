package com.surefix.entity;

import com.surefix.enums.DiagnosticStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Diagnostic effectué par un technicien via l'IA
 * Historique des demandes de diagnostic et leurs résultats
 */
@Entity
@Table(name = "diagnostics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diagnostic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Technicien qui a effectué le diagnostic */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /** Atelier associé */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    /** Appareil concerné (optionnel si non identifié) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appliance_id")
    private Appliance appliance;

    /** Code d'erreur identifié (optionnel) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "error_code_id")
    private ErrorCode errorCode;

    /** Description du problème par le technicien (texte ou transcription vocale) */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String problemDescription;

    /** URL de l'image uploadée (photo du code erreur) */
    private String imageUrl;

    /** Code erreur extrait de l'image par Vision IA */
    private String extractedErrorCode;

    /** Statut du diagnostic */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private DiagnosticStatus status = DiagnosticStatus.PENDING;

    /** Réponse générée par l'IA */
    @Column(columnDefinition = "TEXT")
    private String aiResponse;

    /** Pièces recommandées par l'IA */
    @Column(columnDefinition = "TEXT")
    private String recommendedParts;

    /** Étapes de réparation suggérées */
    @Column(columnDefinition = "TEXT")
    private String repairSteps;

    /** Temps de traitement en millisecondes */
    private Long processingTimeMs;

    /** Modèle IA utilisé (gpt-4, claude-3, etc.) */
    private String aiModel;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
