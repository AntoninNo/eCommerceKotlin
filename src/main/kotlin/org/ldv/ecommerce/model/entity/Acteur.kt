package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class Acteur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nom: String,
    var prenom: String,
    @ManyToMany
    @JoinTable(
        name = "acteur_film",
        joinColumns = [JoinColumn(name = "acteur_id")],
        inverseJoinColumns = [JoinColumn(name = "film_id")]
    )
    var liste_films: MutableList<Film> = mutableListOf(),

    @ManyToMany(mappedBy = "distribution")
    var films: MutableList<Film> = mutableListOf()
    ) {}