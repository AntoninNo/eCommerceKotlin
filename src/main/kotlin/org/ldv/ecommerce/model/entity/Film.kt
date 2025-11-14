package org.ldv.ecommerce.model.entity

import org.w3c.dom.Text

import jakarta.persistence.*

class Film(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nom: String,
    //var realisateur: Realisateur,
    //var genre: Genre,
    var synopsis: Text,
    var prix: Int,
    //var affiche: Image,
    @ManyToMany
    @JoinTable(
        name = "film_acteur",
        joinColumns = [JoinColumn(name = "film_id")],
        inverseJoinColumns = [JoinColumn(name = "acteur_id")]
    )
    var distribution: MutableList<Acteur> = mutableListOf(),

    @ManyToMany(mappedBy = "liste_films")
    var acteurs: MutableList<Acteur> = mutableListOf()
){}