package com.surefix.dto.shop;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un nouvel atelier
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopCreateDTO {

    /** Nom de l'atelier */
    @NotBlank(message = "Le nom de l'atelier est obligatoire")
    private String name;

    /** Adresse complète */
    private String address;

    /** Ville */
    private String city;

    /** Code postal */
    private String postalCode;

    /** Pays */
    private String country;

    /** Téléphone */
    private String phone;

    /** Email de contact */
    @Email(message = "Format email invalide")
    private String email;

    /** Numéro SIRET */
    private String siret;
}
