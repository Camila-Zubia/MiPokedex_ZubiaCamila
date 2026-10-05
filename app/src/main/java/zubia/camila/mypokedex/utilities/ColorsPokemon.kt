package zubia.camila.mypokedex.utilities

import androidx.compose.ui.graphics.Color
import zubia.camila.mypokedex.ui.theme.*

fun getColorByType(type: String): Pair<Color, Color> {
    return when {
        type.contains("Electric", ignoreCase = true) -> {
            Pair(Electric, DarkGray)
        }
        type.contains("Grass", ignoreCase = true) -> {
            Pair(Grass, OffWhitte)
        }
        type.contains("Fire", ignoreCase = true) -> {
            Pair(Fire, OffWhitte)
        }
        type.contains("Water", ignoreCase = true) -> {
            Pair(Water, OffWhitte)
        }
        type.contains("Normal", ignoreCase = true) -> {
            Pair(Normal, OffWhitte)
        }
        type.contains("Bug", ignoreCase = true) -> {
            Pair(Bug, OffWhitte)
        }
        type.contains("Poison", ignoreCase = true) -> {
            Pair(Poison, OffWhitte)
        }
        type.contains("Ground", ignoreCase = true) -> {
            Pair(Ground, OffWhitte)
        }
        type.contains("Rock", ignoreCase = true) -> {
            Pair(Rock, OffWhitte)
        }
        type.contains("Flying", ignoreCase = true) -> {
            Pair(Flying, DarkGray)
        }
        type.contains("Fight", ignoreCase = true) -> {
            Pair(Fight, DarkGray)
        }
        type.contains("Psych", ignoreCase = true) -> {
            Pair(Psych, OffWhitte)
        }
        type.contains("Ghost", ignoreCase = true) -> {
            Pair(Ghost, OffWhitte)
        }
        type.contains("Dragon", ignoreCase = true) -> {
            Pair(Dragon, OffWhitte)
        }
        type.contains("Dark", ignoreCase = true) -> {
            Pair(Dark, OffWhitte)
        }
        type.contains("Ice", ignoreCase = true) -> {
            Pair(Ice, OffWhitte)
        }
        type.contains("Fairy", ignoreCase = true) -> {
            Pair(Fairy, DarkGray)
        }
        else -> {
            Pair(DarkGray, OffWhitte)
        }
    }
}