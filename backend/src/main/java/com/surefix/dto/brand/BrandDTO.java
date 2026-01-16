package com.surefix.dto.brand;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour une marque
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDTO {

    private Integer id;

    /** Nom de la marque */
    private String name;

    /** URL du logo */
    private String logoUrl;

    /** Description */
    private String description;

    /** Marque active ou non */
    private Boolean active;

    /** Nombre de codes d'erreur associés */
    private Integer errorCodeCount;

    /** Date de création */
    private LocalDateTime createdAt;
}
