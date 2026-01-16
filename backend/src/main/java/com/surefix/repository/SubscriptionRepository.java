package com.surefix.repository;

import com.surefix.entity.Subscription;
import com.surefix.enums.SubscriptionPlan;
import com.surefix.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité Subscription (Abonnement)
 */
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    /** Recherche par atelier */
    Optional<Subscription> findByShopId(Integer shopId);

    /** Recherche par statut */
    List<Subscription> findByStatus(SubscriptionStatus status);

    /** Recherche par plan */
    List<Subscription> findByPlan(SubscriptionPlan plan);

    /** Recherche par plan et statut */
    List<Subscription> findByPlanAndStatus(SubscriptionPlan plan, SubscriptionStatus status);

    /** Recherche les abonnements qui expirent avant une date */
    List<Subscription> findByEndDateBefore(LocalDateTime date);

    /** Recherche les abonnements en période d'essai qui expirent avant une date */
    List<Subscription> findByStatusAndTrialEndDateBefore(SubscriptionStatus status, LocalDateTime date);

    /** Vérifie si un atelier a un abonnement */
    boolean existsByShopId(Integer shopId);

    /** Recherche par ID client Stripe */
    Optional<Subscription> findByStripeCustomerId(String stripeCustomerId);

    /** Recherche par ID abonnement Stripe */
    Optional<Subscription> findByStripeSubscriptionId(String stripeSubscriptionId);
}
