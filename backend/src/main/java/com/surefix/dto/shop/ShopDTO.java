package com.surefix.dto.shop;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un atelier
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopDTO {

    private Integer id;

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
    private String email;

    /** Numéro SIRET */
    private String siret;

    /** Nombre de techniciens */
    private Integer technicianCount;

    /** Atelier actif ou non */
    private Boolean active;

    /** Date de création */
    private LocalDateTime createdAt;
}
