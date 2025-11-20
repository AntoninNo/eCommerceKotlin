package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Realisateur
import org.springframework.data.jpa.repository.JpaRepository

interface RealisateurDAO:JpaRepository<Realisateur, Long>  {
}