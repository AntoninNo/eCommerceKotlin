import org.ldv.ecommerce.model.entity.Acteur
import org.springframework.data.jpa.repository.JpaRepository

interface ActeurDAO : JpaRepository<Acteur, Long> {
}

