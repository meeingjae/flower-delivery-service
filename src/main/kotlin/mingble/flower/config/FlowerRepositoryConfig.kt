package mingble.flower.config

import mingble.flower.repository.FlowerRepository
import mingble.flower.repository.FlowerRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlowerRepositoryConfig {

    @Bean
    fun getFlowerRepository(): FlowerRepository {
        return FlowerRepositoryImpl()
    }
}