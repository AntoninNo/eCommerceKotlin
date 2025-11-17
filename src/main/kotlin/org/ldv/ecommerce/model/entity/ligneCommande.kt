package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

class ligneCommande (
    @EmbeddedId
    var commandeId: NoteId? = null,
    var quantité: Int,

    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null,


    @MapsId("commandeId")
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null
) {
}
