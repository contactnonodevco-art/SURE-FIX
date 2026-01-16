package com.surefix.dto.diagnostic;

import com.surefix.enums.FeedbackRating;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un feedback sur un diagnostic
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticFeedbackCreateDTO {

    /** ID du diagnostic concerné */
    @NotNull(message = "L'ID du diagnostic est obligatoire")
    private Integer diagnosticId;

    /** Évaluation du diagnostic */
    @NotNull(message = "L'évaluation est obligatoire")
    private FeedbackRating rating;

    /** Le problème a-t-il été résolu ? */
    @NotNull(message = "Indiquez si le problème a été résolu")
    private Boolean problemResolved;

    /** La pièce recommandée était-elle correcte ? */
    private Boolean correctPartRecommended;

    /** Pièce réellement défaillante (si différente) */
    private String actualDefectivePart;

    /** Commentaire du technicien */
    private String comment;

    /** Temps réel de réparation en minutes */
    private Integer actualRepairTime;
}
