package mingble.flower.service

import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import mingble.flower.entity.Flower
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Service
@Transactional
open class FlowerService(
    private val entityManager: EntityManager,
    private val queryFactory: SpringDataQueryFactory
) {

    fun getAll(name : String): List<Flower> {
        return queryFactory.listQuery<Flower> {
            select(entity(Flower::class))
            from(entity(Flower::class))
            where(col(Flower::name).like("%${name}%"))
        }
    }
}