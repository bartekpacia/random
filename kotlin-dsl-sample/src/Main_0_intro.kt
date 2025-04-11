// Close the Android app.
// Create new Kotlin project.

//region Main function

fun main() {
    val lisbon = Village(
        name = "Lisbon",
        population = 1_000_000,
        houses = listOf(
            Place("MEO Arena"),
            Place("Bridge of 25th April"),
        ),
    )

    val porto = Village(
        name = "Porto",
        population = 500_000,
        houses = listOf(
            Place("Sé do Porto"),
            Place("Ribeira"),
            Place("FEUP"),
        ),
    )

    val braga = Village(
        name = "Braga",
        population = 100_000,
        houses = listOf(
            Place("Bom Jesus do Monte"),
            Place("Santa Barbara Garden"),
        ),
    )

    val road_1 = Road(from = lisbon, to = porto)
    val road_2 = Road(from = porto, to = braga)

    val world = World(
        villages = listOf(lisbon, porto, braga),
        roads = listOf(road_1, road_2),
    )

    println(world)
}

//endregion

/*

//region Data model

data class World(
    val villages: List<Village>,
    val roads: List<Road>
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
    val name: String,
    val population: Int,
    val houses: List<House>
) {
    override fun toString(): String {
        val houseList = houses.joinToString { it.name }
        return " - $name (pop: $population), houses: [$houseList]"
    }
}

data class House(val name: String)

data class Road(val from: Village, val to: Village) {
    override fun toString() = " - ${from.name} ⇄ ${to.name}"
}

//endregion

*/
