package org.ldv.ecommerce.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class NoteId (
    var filmId: Long,
    var commandeId: Long

): Serializable {
}
