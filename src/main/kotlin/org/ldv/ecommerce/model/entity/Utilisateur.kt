package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id:Int?,
    var nom_utilisateur: String,
    var email: String,
    var mdp: String,
    //var film_posseder: List<org.ldv.ecommerce.model.entity.Film>)
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf(),

    @OneToMany(mappedBy = "utilisateur", orphanRemoval = true)
    var notes: MutableList<Avis> = mutableListOf()

)
    {
}