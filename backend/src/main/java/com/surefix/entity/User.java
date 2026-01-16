package com.surefix.entity;

import com.surefix.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Utilisateur de la plateforme Sure Fix
 * Peut être : Super Admin, Propriétaire d'atelier, Admin atelier, Technicien ou Support
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Adresse email - utilisée pour la connexion */
    @Column(nullable = false, unique = true)
    private String email;

    /** Mot de passe hashé */
    @Column(nullable = false)
    private String password;

    /** Prénom */
    @Column(nullable = false)
    private String firstName;

    /** Nom de famille */
    @Column(nullable = false)
    private String lastName;

    /** Numéro de téléphone */
    private String phone;

    /** Rôle de l'utilisateur */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    /** Atelier auquel appartient l'utilisateur (null pour SUPER_ADMIN et SUPPORT) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    /** Compte actif ou désactivé */
    @Column(nullable = false)
    private Boolean active = true;

    /** Date de création du compte */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    /** Date de dernière connexion */
    private LocalDateTime lastLoginAt;

    /**
     * Callback JPA - Exécuté automatiquement AVANT le premier INSERT en base
     * Initialise la date de création
     */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    /**
     * Callback JPA - Exécuté automatiquement AVANT chaque UPDATE en base
     * Met à jour la date de modification
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
