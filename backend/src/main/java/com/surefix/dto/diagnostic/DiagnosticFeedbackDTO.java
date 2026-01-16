package com.surefix.dto.diagnostic;

import com.surefix.enums.FeedbackRating;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un feedback de diagnostic
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticFeedbackDTO {

    private Integer id;

    /** ID du diagnostic concerné */
    private Integer diagnosticId;

    /** Évaluation du diagnostic */
    private FeedbackRating rating;

    /** Le problème a-t-il été résolu ? */
    private Boolean problemResolved;

    /** La pièce recommandée était-elle correcte ? */
    private Boolean correctPartRecommended;

    /** Pièce réellement défaillante (si différente) */
    private String actualDefectivePart;

    /** Commentaire du technicien */
    private String comment;

    /** Temps réel de réparation en minutes */
    private Integer actualRepairTime;

    /** Date de création */
    private LocalDateTime createdAt;
}
