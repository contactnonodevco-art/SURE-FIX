package com.surefix.dto.knowledge;

import com.surefix.enums.ApplianceType;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO pour créer un document technique
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnowledgeDocumentCreateDTO {

    /** Titre du document */
    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    /** Description */
    private String description;

    /** ID de la marque (optionnel) */
    private Integer brandId;

    /** Type d'appareil concerné (optionnel) */
    private ApplianceType applianceType;

    /** URL du fichier */
    @NotBlank(message = "L'URL du fichier est obligatoire")
    private String fileUrl;

    /** Nom du fichier original */
    private String fileName;

    /** Type MIME */
    private String mimeType;

    /** Taille du fichier en octets */
    private Long fileSize;
}
