package mingble

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlowerDeliveryApplication

fun main(args: Array<String>) {
    runApplication<FlowerDeliveryApplication>(*args)
}
