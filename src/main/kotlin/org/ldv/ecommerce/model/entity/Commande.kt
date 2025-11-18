package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Int?,
    var dateCommande: LocalDate,

    @ManyToOne
    @JoinColumn(name = "utilisateur_fk_id")
    var utilisateur: Utilisateur? = null,

    @OneToMany(mappedBy = "commande", orphanRemoval = true)
    var commande: MutableList<LigneCommande> = mutableListOf()

) {
}