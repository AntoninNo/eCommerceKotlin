package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class Realisateur(
    var id:Int?,
    var nom: String,
    var prenom: String,

    @OneToMany(mappedBy = "categorie",cascade = [CascadeType.ALL], orphanRemoval = true)
    var films: MutableList<Film> = mutableListOf()
) {
}