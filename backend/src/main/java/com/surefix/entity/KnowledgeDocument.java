package com.surefix.entity;

import com.surefix.enums.ApplianceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Document de la base de connaissances
 * Manuels PDF, guides techniques, fiches de réparation
 */
@Entity
@Table(name = "knowledge_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnowledgeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Titre du document */
    @Column(nullable = false)
    private String title;

    /** Description du document */
    @Column(columnDefinition = "TEXT")
    private String description;

    /** Marque associée (optionnel) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    /** Type d'appareil concerné (optionnel) */
    @Enumerated(EnumType.STRING)
    private ApplianceType applianceType;

    /** URL du fichier stocké (MinIO/S3) */
    @Column(nullable = false)
    private String fileUrl;

    /** Nom du fichier original */
    private String fileName;

    /** Type MIME du fichier */
    private String mimeType;

    /** Taille du fichier en octets */
    private Long fileSize;

    /** Contenu extrait pour la recherche (texte du PDF) */
    @Column(columnDefinition = "TEXT")
    private String extractedContent;

    /** Document actif ou archivé */
    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    /** Utilisateur qui a uploadé le document */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by")
    private User uploadedBy;

    /** Date de création */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /** Date de dernière mise à jour */
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
