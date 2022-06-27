package mingble.flower.repository

import mingble.flower.entity.Flower
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FlowerRepository : JpaRepository<Flower, Long> {
}