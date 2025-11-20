package org.ldv.ecommerce.controller

import ActeurDAO
import org.ldv.ecommerce.model.dao.AvisDAO
import org.ldv.ecommerce.model.dao.CommandeDAO
import org.ldv.ecommerce.model.dao.FilmDAO
import org.ldv.ecommerce.model.dao.GenreDAO
import org.ldv.ecommerce.model.dao.RealisateurDAO
import org.ldv.ecommerce.model.dao.RoleDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Acteur
import org.ldv.ecommerce.model.entity.Film
import org.ldv.ecommerce.model.entity.Role
import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.*

@ComponentScan
class DataInitializer(
    private val acteurDAO: ActeurDAO,
    private val avisDAO: AvisDAO,
    private val commandeDAO: CommandeDAO,
    private val realisateurDAO: RealisateurDAO,
    private val roleDAO: RoleDAO,
    private val genreDAO: GenreDAO,
    private val filmDAO: FilmDAO,
    private val utilisateurDAO: UtilisateurDAO,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (genreDAO.count() > 0 || filmDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===
//        val genreAction = GenreDAO(nom = "Action")
//        val genreComedie = GenreDAO(nom = "Comédie")
//        val genreDrame = GenreDAO(nom = "Drame")
//
//        genreDAO.saveAll(listOf(genreAction, genreComedie, genreDrame))

        // === Articles ===

        val filmDjango = Film(
            0,
            "Django Unchained",
            "Deux ans avant la Guerre civile, un ancien esclave du nom de Django s'associe avec un chasseur de primes d'origine allemande qui l'a libéré: il accepte de traquer avec lui des criminels recherchés. En échange, il l'aidera à retrouver sa femme perdue depuis longtemps et esclave elle aussi.",
            12,
            mutableListOf(
                Acteur(0, "Waltz", "Christoph"),
                Acteur(2, "Tarantino", "Quentin"),
                Acteur(3, "Foxx", "Jamie")
            )
        )


        // === Sauvegarde des articles ===
//        articleDAO.saveAll(
//            listOf(
//                articleMontre,
//                articleDrone
//
//            )
//        )

//        println("✅ Données initiales insérées : ${GenreDAO.count()} catégories, ${FilmDAO.count()} articles.")

        val roleAdmin = Role(
            nom = "ADMIN"
        )

        val roleClient = Role(
            nom = "CLIENT"
        )

        roleDAO.saveAll(listOf(roleAdmin,roleClient))
        val admin = Utilisateur(
            id = null,
            nom = "Super",
            prenom = "Admin",
            email = "admin@admin.com",
            mdp = passwordEncoder.encode("admin123"), // mot de passe hashé
            role = roleAdmin
        )

        val client = Utilisateur(
            id = null,
            nom = "Jean",
            prenom = "Client",
            email = "client@client.com",
            mdp = passwordEncoder.encode("client123"), // mot de passe hashé
            role = roleClient
        )
        utilisateurDAO.saveAll(listOf(admin, client))


    }
}
