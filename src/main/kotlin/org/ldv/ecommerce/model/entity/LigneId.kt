package org.ldv.ecommerce.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class LigneId (
    var filmId: Long,
    var commandeId: Long
): Serializable {
}
