package org.ldv.ecommerce.controller

import org.ldv.ecommerce.model.dao.FilmDAO
import org.ldv.ecommerce.model.dao.GenreDAO
import org.ldv.ecommerce.model.entity.Acteur
import org.ldv.ecommerce.model.entity.Film
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.*

@Component
class DataInitializer(
    private val genreDAO: GenreDAO,
    private val filmDAO: FilmDAO
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (genreDAO.count() > 0 || filmDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===
        val genreAction = GenreDAO(nom = "Action")
        val genreComedie = GenreDAO(nom = "Comédie")
        val genreDrame = GenreDAO(nom = "Drame")

        genreDAO.saveAll(listOf(genreAction, genreComedie, genreDrame))

        // === Articles ===

        val filmDjango = Film(
            0,
            "Django Unchained",
            "Deux ans avant la Guerre civile, un ancien esclave du nom de Django s'associe avec un chasseur de primes d'origine allemande qui l'a libéré: il accepte de traquer avec lui des criminels recherchés. En échange, il l'aidera à retrouver sa femme perdue depuis longtemps et esclave elle aussi.",
            12,
            mutableListOf(Acteur(0,"Waltz","Christoph"), Acteur(2,"Tarantino","Quentin"), Acteur(3,"Foxx", "Jamie")))

        )

        val articleDrone = Article(
            nom = "Mini drone",
            description = "Drone compact avec caméra HD et contrôle via smartphone.",
            stock = 15,
            prix = 149.99,
            lienImage = "https://example.com/images/mini-drone.jpg",
            categorie = catGadget
        )


        // === Sauvegarde des articles ===
        articleDAO.saveAll(
            listOf(
                articleMontre,
                articleDrone

            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${articleDAO.count()} articles.")
    }
