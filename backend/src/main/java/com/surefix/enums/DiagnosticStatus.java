package com.surefix.enums;

/**
 * Statuts possibles d'un diagnostic
 */
public enum DiagnosticStatus {

    /** En attente - Le diagnostic n'a pas encore été traité */
    PENDING,

    /** En cours - Le diagnostic est en train d'être analysé par l'IA */
    PROCESSING,

    /** Terminé - Le diagnostic a été complété avec succès */
    COMPLETED,

    /** Échoué - Une erreur s'est produite lors du diagnostic */
    FAILED
}
