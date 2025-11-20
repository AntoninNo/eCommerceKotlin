package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Film
import org.springframework.data.jpa.repository.JpaRepository

interface FilmDAO:JpaRepository<Film, Long>  {
}