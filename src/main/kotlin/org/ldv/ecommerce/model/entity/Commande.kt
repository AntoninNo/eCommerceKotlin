package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

class Commande(
    var id: Int?,
    var dateCommande: LocalDate,

    @ManyToOne
    @JoinColumn(name = "utilisateur_fk_id")
    var utilisateur: Utilisateur? = null
) {
}