package com.surefix.dto.diagnostic;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un diagnostic (requête du technicien)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticCreateDTO {

    /** ID de l'appareil (optionnel si non identifié) */
    private Integer applianceId;

    /** Description du problème */
    @NotBlank(message = "La description du problème est obligatoire")
    private String problemDescription;

    /** URL de l'image uploadée (photo du code erreur) */
    private String imageUrl;
}
