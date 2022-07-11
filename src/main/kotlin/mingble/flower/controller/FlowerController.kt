package mingble.flower.controller

import mingble.flower.entity.Flower
import mingble.flower.repository.FlowerRepository
import mingble.flower.repository.FlowerRepositoryCustom
import mingble.flower.service.FlowerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.Flow

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
        @RequestParam(required = false, defaultValue = "") name: String,
        @RequestParam(required = false, defaultValue = "") ids: List<Long>
    ): ResponseEntity<List<Flower>> {
        if (ids.isNotEmpty()) {
            return ResponseEntity.ok(flowerService.getByFlowerIds(ids))
        }
        return ResponseEntity.ok(flowerService.getAll(name))
    }

    @PutMapping("/jdsl")
    fun updateFlower(@RequestBody flower: Flower): ResponseEntity<Flower> {
        return ResponseEntity.ok(null)
    }

    @DeleteMapping("/jdsl")
    fun deleteFlower(@RequestParam id: Long) : ResponseEntity<Flow> {
        return ResponseEntity.ok(null)
    }
}