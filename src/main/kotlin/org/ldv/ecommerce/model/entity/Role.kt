package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    var nom:String,
    @OneToMany(mappedBy = "role", cascade = [CascadeType.ALL], orphanRemoval = true)
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
)
