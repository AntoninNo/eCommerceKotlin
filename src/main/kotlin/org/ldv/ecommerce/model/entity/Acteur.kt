package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class Acteur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nom: String,
    var prenom: String,


    @ManyToMany(mappedBy = "distribution")
    var films: MutableList<Film> = mutableListOf()
    ) {}