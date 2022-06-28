package mingble.flower.controller

import mingble.flower.entity.Flower
import mingble.flower.repository.FlowerRepository
import mingble.flower.repository.FlowerRepositoryCustom
import mingble.flower.service.FlowerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/flower")
class FlowerController(
    private val flowerRepository: FlowerRepository,
    private val flowerRepositoryCustom: FlowerRepositoryCustom,
    private val flowerService: FlowerService
) {

    @GetMapping
    fun getAll(): List<Flower> {
        return flowerRepository.findAll()
    }

    @GetMapping("/dsl")
    fun getAllByDsl(): List<Flower> {
        return flowerRepositoryCustom.findAll()
    }

    @GetMapping("/jdsl")
    fun getAllByJdsl(
        @RequestParam(value = "name", required = false, defaultValue = "first") name : String
    ): ResponseEntity<List<Flower>> {
        return ResponseEntity.ok(flowerService.getAll(name))
    }
}