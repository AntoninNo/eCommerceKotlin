package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Utilisateur(

    /**
     * Identifiant unique de l'utilisateur.
     * Généré automatiquement par la base de données (auto-increment).
     * - @Id : clé primaire
     * - @GeneratedValue : stratégie de génération
     * - @Column(nullable = false) : la colonne ne peut pas être NULL
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    /**
     * Nom de l'utilisateur.
     */
    var nom: String,
    /**
     * Prénom de l'utilisateur.
     */
    var prenom: String,
    /**
     * Adresse e-mail de l'utilisateur.
     * Peut servir comme identifiant de connexion.
     */
    var email: String,
    /**
     * Mot de passe de l'utilisateur.
     * ⚠️ À stocker obligatoirement hashé (BCrypt) !
     */
    var mdp: String,
    /**
     * Date de création de l’enregistrement.
     * - initialisée automatiquement lors de la création
     * - non modifiable après insertion (updatable = false)
     */
    @Column(nullable = false, updatable = false)
    var dateCreation: LocalDateTime = LocalDateTime.now(),
    /**
     * Date de dernière modification de l'enregistrement.
     * Mise à jour automatiquement avant chaque mise à jour en base (@PreUpdate).
     */
    @Column(nullable = false)
    var dateModification: LocalDateTime = LocalDateTime.now(),

    /**
     * Relation ManyToOne : un utilisateur possède un seul rôle.
     * - @JoinColumn : nom de la colonne clé étrangère (role_id)
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null,

        //var film_posseder: List<org.ldv.ecommerce.model.entity.Film>)

        @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf(),

    @OneToMany(mappedBy = "utilisateur", orphanRemoval = true)
    var notes: MutableList<Avis> = mutableListOf()
) {

    /**
     * Méthode exécutée automatiquement avant chaque update JPA.
     * Elle met à jour la date de modification.
     */
    @PreUpdate
    fun preUpdate() {
        dateModification = LocalDateTime.now()
    }
}
