package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

class Avis(
    @EmbeddedId
    var avisId: AvisId? = null,


    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null,


    @MapsId("utilisateurId")
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null




//    var id:Int?,
//    //var nom_utilisateur: Utilisateur,
//    var date: LocalDate,
//    //var film: Film,
//    var note: Int,
//    var texte: String
) {
}