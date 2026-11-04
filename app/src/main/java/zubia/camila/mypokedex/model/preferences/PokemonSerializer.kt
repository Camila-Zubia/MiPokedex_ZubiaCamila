package zubia.camila.mypokedex.model.preferences

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import zubia.camila.mypokedex.model.domain.Pokemon
import java.io.InputStream
import java.io.OutputStream

object PokemonSerializer: Serializer<Pokemon> {
    override val defaultValue: Pokemon = Pokemon(
        name = "",
        num = -1,
        type = "",
        description = "",
        height = 0f,
        weight= 0f,
        fav = false,
        ability = "",
        image = -1
    )
    override suspend fun readFrom(input: InputStream): Pokemon{

        return try {
            Json.decodeFromString(
                Pokemon.serializer(), input.readBytes().decodeToString()
            )
        }catch (exception: SerializationException){
            throw CorruptionException("No se puedo leer el JSON", exception)
        }
    }
    override suspend fun writeTo(t: Pokemon, output: OutputStream){
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(Pokemon.serializer(), t).encodeToByteArray()
            )
        }
    }
}