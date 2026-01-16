package com.surefix.repository;

import com.surefix.entity.DiagnosticFeedback;
import com.surefix.enums.FeedbackRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository pour l'entité DiagnosticFeedback
 */
@Repository
public interface DiagnosticFeedbackRepository extends JpaRepository<DiagnosticFeedback, Integer> {

    /** Recherche par diagnostic */
    Optional<DiagnosticFeedback> findByDiagnosticId(Integer diagnosticId);

    /** Recherche par évaluation */
    List<DiagnosticFeedback> findByRating(FeedbackRating rating);

    /** Recherche les feedbacks où le problème a été résolu */
    List<DiagnosticFeedback> findByProblemResolved(Boolean problemResolved);

    /** Vérifie si un feedback existe pour un diagnostic */
    boolean existsByDiagnosticId(Integer diagnosticId);
}
