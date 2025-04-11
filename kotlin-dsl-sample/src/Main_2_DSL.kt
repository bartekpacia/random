//region Main function

fun main() {
    val world = world {
        val lisbon = village("Lisbon") {
            population = 1_000_000
            house("MEO Arena")
            house("Bridge of 25th April")
        }

        val porto = village("Porto") {
            population = 500_000
            house("Sé do Porto")
            house("Ribeira")
            house("FEUP")
        }

        val braga = village("Braga") {
            population = 100_000
            house("Bom Jesus do Monte")
            house("Santa Barbara Garden")

            // WARNING: A loophole!
            // This seems wrong, right?
            road(lisbon, porto)
            this@world.road(lisbon, porto)
        }

        road(lisbon, porto)
        road(porto, braga)
    }

    println(world)
}


//endregion

//region DSL Implementation

@DslMarker
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class WorldDsl

@DslMarker
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class VillageDsl

fun world(init: WorldBuilder.() -> Unit): World {
    return WorldBuilder().apply(init).build()
}

@WorldDsl
class WorldBuilder {
    // Holds state so we can incrementally build up the world.
    internal val villages = mutableListOf<Village>()
    internal val roads = mutableListOf<Road>()

    fun build(): World = World(villages, roads)
}

fun WorldBuilder.village(name: String, init: VillageBuilder.() -> Unit): Village {
    val builder = VillageBuilder(name).apply(init)
    val village = builder.build()
    villages += village
    return village
}

fun WorldBuilder.road(from: Village, to: Village) {
    roads += Road(from, to)
}

@WorldDsl
class VillageBuilder(private val name: String) {
    var population: Int = 0
    private val houses = mutableListOf<Place>()

    fun house(name: String) {
        houses += Place(name)
    }

    fun build(): Village = Village(name, population, houses)
}

fun

//region Data model

        data

class World(
    val villages: List<Village>,
    val roads: List<Road>,
) {
    override fun toString(): String {
        return buildString {
            appendLine("Villages:")
            villages.forEach { appendLine(it) }
            appendLine("Roads:")
            roads.forEach { appendLine(it) }
        }
    }
}

data class Village(
    val name: String, val population: Int, val houses: List<Place>
) {
    override fun toString(): String {
        val houseList = houses.joinToString { it.name }
        return " - $name (pop: $population), houses: [$houseList]"
    }
}

data class Place(val name: String)

data class Road(val from: Village, val to: Village) {
    override fun toString() = " - ${from.name} ⇄ ${to.name}"
}

//endregion
