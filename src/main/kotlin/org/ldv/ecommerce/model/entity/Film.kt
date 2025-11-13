package org.ldv.ecommerce.model.entity

import org.w3c.dom.Text

class Film(
    var id: Int?,
    var nom: String,
    //var realisateur: Realisateur,
    //var genre: Genre,
    var synopsis: Text,
    var prix: Int,
    //var affiche: Image,
    //var distribution: List<Acteurs>
    ){}