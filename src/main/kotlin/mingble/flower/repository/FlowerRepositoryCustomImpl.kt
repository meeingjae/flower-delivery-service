package mingble.flower.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import mingble.flower.entity.Flower
import mingble.flower.entity.QFlower
import org.springframework.stereotype.Repository

class FlowerRepositoryCustomImpl (private val query : JPAQueryFactory) : FlowerRepositoryCustom {

    private val flower : QFlower = QFlower.flower
    override fun findAll(): List<Flower> {
        return query.selectFrom(flower)
            .fetch()
    }
}