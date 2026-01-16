package com.surefix.dto.user;

import com.surefix.enums.UserRole;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un utilisateur
 * Utilisé pour les GET - Ne contient jamais le mot de passe
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Integer id;

    /** Adresse email */
    private String email;

    /** Prénom */
    private String firstName;

    /** Nom de famille */
    private String lastName;

    /** Numéro de téléphone */
    private String phone;

    /** Rôle de l'utilisateur */
    private UserRole role;

    /** ID de l'atelier (si applicable) */
    private Integer shopId;

    /** Nom de l'atelier (si applicable) */
    private String shopName;

    /** Compte actif ou non */
    private Boolean active;

    /** Date de création */
    private LocalDateTime createdAt;

    /** Dernière connexion */
    private LocalDateTime lastLoginAt;
}
