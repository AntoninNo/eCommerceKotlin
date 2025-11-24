package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Realisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,
    var nom: String,
    var prenom: String,

    @OneToMany(mappedBy = "realisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var films: MutableList<Film> = mutableListOf()
) {
}