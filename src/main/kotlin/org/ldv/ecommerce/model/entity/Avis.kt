package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Avis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    @EmbeddedId
    var avisId: AvisId? = null,
    var date: LocalDate,
    var note: Int,

    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null,


    @MapsId("utilisateurId")
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null,

    var texte: String
) {
}