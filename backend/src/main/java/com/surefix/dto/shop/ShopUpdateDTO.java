package com.surefix.dto.shop;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour mettre à jour un atelier
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopUpdateDTO {

    /** Nom de l'atelier */
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

    /** Atelier actif ou non */
    private Boolean active;
}
