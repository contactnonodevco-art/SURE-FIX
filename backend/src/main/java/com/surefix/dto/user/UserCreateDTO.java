package com.surefix.dto.user;

import com.surefix.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un nouvel utilisateur
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDTO {

    /** Adresse email - utilisée pour la connexion */
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format email invalide")
    private String email;

    /** Mot de passe */
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;

    /** Prénom */
    @NotBlank(message = "Le prénom est obligatoire")
    private String firstName;

    /** Nom de famille */
    @NotBlank(message = "Le nom est obligatoire")
    private String lastName;

    /** Numéro de téléphone */
    private String phone;

    /** Rôle de l'utilisateur */
    @NotNull(message = "Le rôle est obligatoire")
    private UserRole role;

    /** ID de l'atelier (obligatoire sauf pour SUPER_ADMIN et SUPPORT) */
    private Integer shopId;
}
