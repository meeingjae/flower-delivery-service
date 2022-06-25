package mingble.flower.entity

import javax.persistence.*

@Entity
@Table(name = "D_FLOWER")
class Flower(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val name: String,
    @Column
    val price: Long,
    @Column
    val message: String,
)