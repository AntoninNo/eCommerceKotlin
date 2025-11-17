package org.ldv.ecommerce.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class AvisId (
    var filmId: Long,
    var utilisateurId: Long
): Serializable {
}
