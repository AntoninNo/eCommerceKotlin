package org.ldv.ecommerce.model.entity

import java.time.LocalDate

class Avis(
    var id:Int?,
    //var nom_utilisateur: Utilisateur,
    var date: LocalDate,
    //var film: Film,
    var note: Int,
    var texte: String
) {
}