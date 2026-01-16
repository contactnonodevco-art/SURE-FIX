# Notes Techniques - Sure Fix Backend

Ce document compile les explications techniques données pendant le développement du projet.

---

## 1. @PrePersist et @PreUpdate

Ce sont des **callbacks JPA** (Java Persistence API) qui s'exécutent automatiquement :

| Annotation | Quand ? | Utilité |
|------------|---------|---------|
| `@PrePersist` | **Avant** le premier `INSERT` en base | Initialiser `createdAt` automatiquement |
| `@PreUpdate` | **Avant** chaque `UPDATE` en base | Mettre à jour `updatedAt` automatiquement |

### Exemple :

```java
// Quand tu fais :
User user = new User();
user.setEmail("test@email.com");
userRepository.save(user);  // ← @PrePersist s'exécute ICI avant l'INSERT

// Plus tard :
user.setFirstName("Jean");
userRepository.save(user);  // ← @PreUpdate s'exécute ICI avant l'UPDATE
```

**Avantage** : Tu n'as jamais besoin de gérer manuellement les dates `createdAt` et `updatedAt`, JPA le fait pour toi.

---

## 2. @Builder.Default (Lombok)

Quand on utilise `@Builder` de Lombok, les valeurs initialisées dans la classe sont **ignorées** par le builder par défaut.

### Problème SANS @Builder.Default :

```java
@Builder
public class Shop {
    private List<User> users = new ArrayList<>();  // Cette initialisation est IGNORÉE
}

Shop shop = Shop.builder().name("Mon atelier").build();
shop.getUsers();  // ❌ Retourne NULL (pas une liste vide !)
```

### Solution AVEC @Builder.Default :

```java
@Builder
public class Shop {
    @Builder.Default
    private List<User> users = new ArrayList<>();  // Le builder respecte cette valeur
}

Shop shop = Shop.builder().name("Mon atelier").build();
shop.getUsers();  // ✅ Retourne une ArrayList vide
```

---

## 3. Relations JPA : @OneToMany et @ManyToOne

### Exemple : Shop ↔ User

```java
// Côté Shop (1 atelier a PLUSIEURS utilisateurs)
@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
private List<User> users = new ArrayList<>();

// Côté User (1 utilisateur appartient à 1 SEUL atelier)
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "shop_id")
private Shop shop;
```

| Côté | Annotation | Signification |
|------|------------|---------------|
| `Shop` | `@OneToMany` | **UN** atelier peut avoir **PLUSIEURS** utilisateurs |
| `User` | `@ManyToOne` | **UN** utilisateur appartient à **UN SEUL** atelier |

Le `mappedBy = "shop"` indique que la clé étrangère (`shop_id`) est dans la table `users`, pas dans `shops`.

---

## 4. FetchType.LAZY vs FetchType.EAGER

| FetchType | Comportement | Quand utiliser |
|-----------|--------------|----------------|
| `LAZY` | Charge la relation **seulement quand on y accède** | Par défaut pour `@ManyToOne`, `@OneToMany` - **Recommandé** |
| `EAGER` | Charge la relation **immédiatement** avec l'entité parente | Rarement, peut causer des problèmes de performance |

### Exemple avec LAZY :

```java
// Avec LAZY
Diagnostic diag = diagnosticRepository.findById(1);
// → Requête SQL: SELECT * FROM diagnostics WHERE id = 1
// → L'objet User n'est PAS encore chargé

diag.getUser().getFirstName();
// → Requête SQL: SELECT * FROM users WHERE id = X
// → L'objet User est chargé MAINTENANT (à la demande)
```

### Exemple avec EAGER :

```java
// Avec EAGER
Diagnostic diag = diagnosticRepository.findById(1);
// → Requête SQL: SELECT * FROM diagnostics JOIN users... WHERE id = 1
// → L'objet User est chargé IMMÉDIATEMENT (même si on n'en a pas besoin)
```

**LAZY = meilleure performance** car on ne charge que ce dont on a besoin.

---

## 5. CascadeType et orphanRemoval

### CascadeType.ALL

Propage toutes les opérations (persist, merge, remove, refresh, detach) de l'entité parente vers les entités enfants.

```java
@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
private List<User> users;

// Si on supprime un Shop, tous ses Users sont aussi supprimés
shopRepository.delete(shop);  // → Supprime aussi tous les users du shop
```

### orphanRemoval = true

Supprime automatiquement les entités enfants qui ne sont plus référencées par le parent.

```java
@OneToMany(mappedBy = "shop", orphanRemoval = true)
private List<User> users;

// Si on retire un user de la liste, il est supprimé de la base
shop.getUsers().remove(user);  // → DELETE FROM users WHERE id = X
```

---

## 6. @Column options

| Option | Description | Exemple |
|--------|-------------|---------|
| `nullable = false` | Colonne NOT NULL | `@Column(nullable = false)` |
| `unique = true` | Contrainte d'unicité | `@Column(unique = true)` |
| `updatable = false` | Ne peut pas être modifié après INSERT | `@Column(updatable = false)` |
| `columnDefinition = "TEXT"` | Type SQL personnalisé | `@Column(columnDefinition = "TEXT")` |

---

## 7. @Enumerated

Définit comment un enum Java est stocké en base de données.

| Option | Stockage | Exemple en base |
|--------|----------|-----------------|
| `EnumType.STRING` | Nom de la constante (texte) | `"TECHNICIAN"` |
| `EnumType.ORDINAL` | Position dans l'enum (entier) | `3` |

**Toujours utiliser `EnumType.STRING`** car :
- Plus lisible en base
- Pas de problème si on réordonne les valeurs de l'enum

```java
@Enumerated(EnumType.STRING)
private UserRole role;  // Stocké comme "TECHNICIAN" en base
```

---

## 8. Annotations Lombok utilisées

| Annotation | Ce qu'elle génère |
|------------|-------------------|
| `@Getter` | Tous les getters |
| `@Setter` | Tous les setters |
| `@NoArgsConstructor` | Constructeur sans arguments |
| `@AllArgsConstructor` | Constructeur avec tous les arguments |
| `@Builder` | Pattern Builder pour créer des objets |
| `@Builder.Default` | Valeur par défaut respectée par le Builder |

---

*Document généré pendant le développement du projet Sure Fix*
