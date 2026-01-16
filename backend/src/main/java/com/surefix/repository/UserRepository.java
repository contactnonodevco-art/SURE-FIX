package com.surefix.repository;

import com.surefix.entity.User;
import com.surefix.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /** Recherche par email */
    Optional<User> findByEmail(String email);

    /** Recherche par ID d'atelier */
    List<User> findByShopId(Integer shopId);

    /** Recherche par rôle */
    List<User> findByRole(UserRole role);

    /** Recherche par atelier et rôle */
    List<User> findByShopIdAndRole(Integer shopId, UserRole role);

    /** Recherche par email et actif */
    Optional<User> findByEmailAndActive(String email, Boolean active);

    /** Vérifie si un email existe */
    boolean existsByEmail(String email);
}
