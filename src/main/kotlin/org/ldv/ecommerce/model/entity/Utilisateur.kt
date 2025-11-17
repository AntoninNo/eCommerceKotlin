package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class Utilisateur(
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