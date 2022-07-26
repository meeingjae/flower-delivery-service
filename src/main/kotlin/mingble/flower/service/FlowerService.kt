package mingble.flower.service

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import mingble.flower.entity.Flower
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
open class FlowerService(
    private val queryFactory: SpringDataQueryFactory
) {

    open fun getAll(name: String): List<Flower> {
        return queryFactory.listQuery<Flower> {
            select(entity(Flower::class))
            from(entity(Flower::class))
            where(col(Flower::name).like("%${name}%"))
        }
    }

    open fun getByFlowerIds(ids: List<Long>): List<Flower> {
        return queryFactory.listQuery {
            selectDistinct(entity(Flower::class))
            from(Flower::class)
            where(
                and(col(Flower::id).`in`(ids))
            )
        }
    }

    open fun updateFlower(flower: Flower): Int {
        return queryFactory.updateQuery(Flower::class) {
            where(col(Flower::id).equal(flower.id))
            set(col(Flower::name), flower.name)
            set(col(Flower::message), flower.message)
            set(col(Flower::price), flower.price)
        }.executeUpdate()
    }

    open fun deleteFlower(id: Long): Int {
        return queryFactory.deleteQuery(Flower::class) {
            where(col(Flower::id).equal(id))
        }.executeUpdate()
    }
}