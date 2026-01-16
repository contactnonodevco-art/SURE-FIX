package com.surefix.dto.brand;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer une marque
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandCreateDTO {

    /** Nom de la marque */
    @NotBlank(message = "Le nom de la marque est obligatoire")
    private String name;

    /** URL du logo */
    private String logoUrl;

    /** Description */
    private String description;
}
