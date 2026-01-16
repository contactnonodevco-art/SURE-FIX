package com.surefix.enums;

/**
 * Statuts possibles d'un abonnement
 */
public enum SubscriptionStatus {

    /** Actif - L'abonnement est en cours et valide */
    ACTIVE,

    /** Annulé - L'abonnement a été annulé par le client */
    CANCELLED,

    /** Expiré - L'abonnement a expiré (non renouvelé) */
    EXPIRED,

    /** Essai gratuit - Période d'essai en cours */
    TRIAL
}
