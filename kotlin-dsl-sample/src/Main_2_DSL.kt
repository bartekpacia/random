//region Main function

fun main() {
    val world = world {
        val lisbon = village("Lisbon") {
            population = 1_000_000
            place("MEO Arena")
            place("Bridge of 25th April")
        }

        val porto = village("Porto") {
            population = 500_000
            place("Sé do Porto")
            place("Ribeira")
            place("FEUP")
        }

        val braga = village("Braga") {
            population = 100_000
            place("Bom Jesus do Monte")
            place("Santa Barbara Garden")

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

fun world(init: WorldBuilder.() -> Unit): World {
    return WorldBuilder().apply(init).build()
}

@WorldDsl
class WorldBuilder {
    // Holds state so we can incrementally build up the world.
    private val villages = mutableListOf<Village>()
    private val roads = mutableListOf<Road>()

    fun build(): World = World(villages, roads)

    fun village(name: String, init: VillageBuilder.() -> Unit): Village {
        val builder = VillageBuilder(name).apply(init)
        val village = builder.build()
        villages += village
        return village
    }

    fun road(from: Village, to: Village) {
        roads += Road(from, to)
    }
}

@WorldDsl
class VillageBuilder(private val name: String) {
    var population: Int = 0
    private val places = mutableListOf<Place>()

    fun place(name: String) {
        places += Place(name)
    }

    fun build(): Village = Village(name, population, places)
}

//region Data model

data class World(
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
    val name: String, val population: Int, val places: List<Place>
) {
    override fun toString(): String {
        val placeList = places.joinToString { it.name }
        return " - $name (pop: $population), houses: [$placeList]"
    }
}

data class Place(val name: String)

data class Road(val from: Village, val to: Village) {
    override fun toString() = " - ${from.name} ⇄ ${to.name}"
}

//endregion
