package com.surefix.dto.knowledge;

import com.surefix.enums.ApplianceType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour un document technique
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnowledgeDocumentDTO {

    private Integer id;

    /** Titre du document */
    private String title;

    /** Description */
    private String description;

    /** ID de la marque */
    private Integer brandId;

    /** Nom de la marque */
    private String brandName;

    /** Type d'appareil concerné */
    private ApplianceType applianceType;

    /** URL du fichier */
    private String fileUrl;

    /** Nom du fichier original */
    private String fileName;

    /** Type MIME */
    private String mimeType;

    /** Taille du fichier en octets */
    private Long fileSize;

    /** Document actif ou non */
    private Boolean active;

    /** ID de l'utilisateur qui a uploadé */
    private Integer uploadedById;

    /** Nom de l'utilisateur qui a uploadé */
    private String uploadedByName;

    /** Date de création */
    private LocalDateTime createdAt;
}
