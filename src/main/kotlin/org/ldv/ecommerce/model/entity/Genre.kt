package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class Genre(
    var id: Int?,
    var nom: String,

    @ManyToMany(mappedBy = "genre")
    var films: MutableList<Film> = mutableListOf()

) {
}