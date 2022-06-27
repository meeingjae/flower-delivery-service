package mingble.flower.config

import com.querydsl.jpa.impl.JPAQueryFactory
import mingble.flower.repository.FlowerRepositoryCustom
import mingble.flower.repository.FlowerRepositoryCustomImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QueryDslConfiguration(
    @PersistenceContext
    val entityManager: EntityManager
) {
    @Bean
    fun jpaQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }

    @Bean
    fun flowerRepositoryCustom(): FlowerRepositoryCustom {
        return FlowerRepositoryCustomImpl(jpaQueryFactory())
    }
}