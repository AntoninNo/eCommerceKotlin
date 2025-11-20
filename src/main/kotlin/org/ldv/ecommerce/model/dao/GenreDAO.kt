package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreDAO:JpaRepository<Genre, Long>  {
}