package mingble.flower.service

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import mingble.flower.entity.Flower
import org.springframework.stereotype.Service

@Service
open class FlowerService(
    private val queryFactory: SpringDataQueryFactory
) {

    fun getAll(name: String): List<Flower> {
        return queryFactory.listQuery<Flower> {
            select(entity(Flower::class))
            from(entity(Flower::class))
            where(col(Flower::name).like("%${name}%"))
        }
    }

    fun getByFlowerIds(ids: List<Long>): List<Flower> {
        return queryFactory.listQuery {
            selectDistinct(entity(Flower::class))
            from(Flower::class)
            where(
                and(col(Flower::id).`in`(ids))
            )
        }
    }
}