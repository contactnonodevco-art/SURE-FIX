package com.surefix.entity;

import com.surefix.enums.FeedbackRating;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Feedback du technicien sur un diagnostic
 * Permet d'améliorer l'IA via apprentissage continu
 */
@Entity
@Table(name = "diagnostic_feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Diagnostic concerné */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_id", nullable = false, unique = true)
    private Diagnostic diagnostic;

    /** Évaluation du diagnostic */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeedbackRating rating;

    /** Le diagnostic a-t-il résolu le problème ? */
    @Column(nullable = false)
    private Boolean problemResolved;

    /** La pièce recommandée était-elle correcte ? */
    private Boolean correctPartRecommended;

    /** Pièce réellement défaillante (si différente) */
    private String actualDefectivePart;

    /** Commentaire libre du technicien */
    @Column(columnDefinition = "TEXT")
    private String comment;

    /** Temps réel de réparation en minutes */
    private Integer actualRepairTime;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
