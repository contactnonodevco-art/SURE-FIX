package com.surefix.dto.user;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour mettre à jour un utilisateur
 * Tous les champs sont optionnels
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDTO {

    /** Prénom */
    @Size(min = 2, message = "Le prénom doit contenir au moins 2 caractères")
    private String firstName;

    /** Nom de famille */
    private String lastName;

    /** Numéro de téléphone */
    private String phone;

    /** Compte actif ou non */
    private Boolean active;
}
