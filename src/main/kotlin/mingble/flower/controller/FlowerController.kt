package mingble.flower.controller

import mingble.flower.entity.Flower
import mingble.flower.repository.FlowerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/flower")
class FlowerController (private val flowerRepository: FlowerRepository){

    @GetMapping
    fun getAll() : List<Flower> {
        return flowerRepository.findAll()
    }
}