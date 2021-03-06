package mingble.flower.controller

import mingble.flower.entity.Flower
import mingble.flower.repository.FlowerRepository
import mingble.flower.repository.FlowerRepositoryCustom
import mingble.flower.service.FlowerService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.concurrent.Flow

@RestController
@RequestMapping("/flower")
open class FlowerController(
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
    open fun updateFlower(@RequestBody flower: Flower): ResponseEntity<Int> {
        if (flowerService.updateFlower(flower) == 1) {
            return ResponseEntity.ok().build()
        } else {
            return ResponseEntity.internalServerError().build()
        }
    }

    @DeleteMapping("/jdsl")
    open fun deleteFlower(@RequestParam id: Long) : ResponseEntity<Flow> {
        if (flowerService.deleteFlower(id) == 1) {
            return ResponseEntity.ok().build()
        } else {
            return ResponseEntity.internalServerError().build()
        }
    }
}