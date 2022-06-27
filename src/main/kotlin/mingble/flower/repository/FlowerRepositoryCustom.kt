package mingble.flower.repository

import mingble.flower.entity.Flower

interface FlowerRepositoryCustom {
    fun findAll(): List<Flower>
}