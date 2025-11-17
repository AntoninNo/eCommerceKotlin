package org.ldv.ecommerce.model.entity

import org.w3c.dom.Text

import jakarta.persistence.*

class Film(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nom: String,
    var synopsis: Text,
    var prix: Int,
    //var affiche: Image,

    @ManyToMany
    @JoinTable(
        name = "film_acteur",
        joinColumns = [JoinColumn(name = "film_fk_id")],
        inverseJoinColumns = [JoinColumn(name = "acteur_fk_id")]
    )
    var distribution: MutableList<Acteur> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "film_genre",
        joinColumns = [JoinColumn(name = "film_fk_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_fk_id")]
    )
    var genre: MutableList<Genre> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "realisateur_fk_id")
    var realisateur: Realisateur? = null,

    @OneToMany(mappedBy = "film", orphanRemoval = true)
    var avis: MutableList<Avis> = mutableListOf(),

    @OneToMany(mappedBy = "film", orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf()


    ){}