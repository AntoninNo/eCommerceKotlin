package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Genre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?=null,
    var nom: String,

    @ManyToMany(mappedBy = "genre")
    var films: MutableList<Film> = mutableListOf()

) {
}