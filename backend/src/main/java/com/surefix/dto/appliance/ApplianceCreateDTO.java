package com.surefix.dto.appliance;

import com.surefix.enums.ApplianceType;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un appareil
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplianceCreateDTO {

    /** ID de la marque */
    @NotNull(message = "La marque est obligatoire")
    private Integer brandId;

    /** Type d'appareil */
    @NotNull(message = "Le type d'appareil est obligatoire")
    private ApplianceType type;

    /** Numéro de modèle */
    @NotBlank(message = "Le numéro de modèle est obligatoire")
    private String modelNumber;

    /** Nom commercial du modèle */
    private String modelName;

    /** Année de fabrication */
    private Integer year;

    /** URL de l'image */
    private String imageUrl;
}
