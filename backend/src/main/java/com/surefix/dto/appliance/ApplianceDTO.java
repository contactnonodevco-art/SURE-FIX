package com.surefix.dto.appliance;

import com.surefix.enums.ApplianceType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un appareil
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplianceDTO {

    private Integer id;

    /** ID de la marque */
    private Integer brandId;

    /** Nom de la marque */
    private String brandName;

    /** Type d'appareil */
    private ApplianceType type;

    /** Numéro de modèle */
    private String modelNumber;

    /** Nom commercial du modèle */
    private String modelName;

    /** Année de fabrication */
    private Integer year;

    /** URL de l'image */
    private String imageUrl;

    /** Date de création */
    private LocalDateTime createdAt;
}
