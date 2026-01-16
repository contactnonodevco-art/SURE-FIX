package com.surefix.enums;

/**
 * Rôles des utilisateurs de la plateforme Sure Fix
 */
public enum UserRole {

    /** Super administrateur - Accès total à la plateforme */
    SUPER_ADMIN,

    /** Propriétaire d'atelier - Gestion de son atelier, techniciens, abonnement */
    SHOP_OWNER,

    /** Administrateur d'atelier - Comme SHOP_OWNER sans accès facturation */
    SHOP_ADMIN,

    /** Technicien terrain - Diagnostics et historique personnel */
    TECHNICIAN,

    /** Support client - Lecture seule, assistance utilisateurs */
    SUPPORT
}
