package zubia.camila.mypokedex.sqlite

import android.R.attr.name
import android.content.ContentValues
import android.database.Cursor
import zubia.camila.mypokedex.model.domain.Pokemon

class PokemonMapper(){
    fun getPokemon(cursor: Cursor): Pokemon {
        val num = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NUMBER))
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NAME))
        val type = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_TYPE))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_DESCRIPTION))
        val weight = cursor.getFloat(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_WEIGHT))
        val height = cursor.getFloat(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_HEIGHT))
        val fav = cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_FAV)
        val ability = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_ABILITY))
        val image = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_IMAGE))

        return Pokemon(
            name = name,
            num = num,
            type = type,
            description = description,
            weight = weight,
            height = height,
            fav =
                if(fav == 1){
                    true
                }else{
                    false
                },
            ability = ability,
            image = image
        )
    }

    fun getContentValues(pokemon:Pokemon): ContentValues{
        val values = ContentValues().apply {
            put(Contract.Pokemons.COLUMN_NAME_NUMBER, pokemon.num)
            put(Contract.Pokemons.COLUMN_NAME_NAME, pokemon.name)
            put(Contract.Pokemons.COLUMN_NAME_TYPE, pokemon.type)
            put(Contract.Pokemons.COLUMN_NAME_DESCRIPTION, pokemon.description)
            put(Contract.Pokemons.COLUMN_NAME_ABILITY, pokemon.ability)
            put(Contract.Pokemons.COLUMN_NAME_FAV, pokemon.fav)
            put(Contract.Pokemons.COLUMN_NAME_WEIGHT, pokemon.weight)
            put(Contract.Pokemons.COLUMN_NAME_HEIGHT, pokemon.height)
            put(Contract.Pokemons.COLUMN_NAME_IMAGE, pokemon.image)
        }
        return values
    }
}