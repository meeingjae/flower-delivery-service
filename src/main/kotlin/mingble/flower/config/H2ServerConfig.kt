package mingble.flower.config

import com.zaxxer.hikari.HikariDataSource
import org.h2.tools.Server
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.persistence.EntityManager
import javax.sql.DataSource

@Configuration
@Profile("dev")
open class H2ServerConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    open fun dataSource(): DataSource {
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start()
        return HikariDataSource()
    }

    @Bean
    open fun entityManager(entityManager: EntityManager): EntityManager {
        return entityManager
    }
}