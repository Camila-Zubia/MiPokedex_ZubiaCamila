package zubia.camila.mypokedex.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.database.sqlite.transaction

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createPokemons = "CREATE TABLE ${Contract.Pokemons.TABLE_NAME}( " +
                "${Contract.Pokemons.COLUMN_ID} INTEGER PRIMARY KEY," +
                "${Contract.Pokemons.COLUMN_NAME_NUMBER} INTERGER," +
                "${Contract.Pokemons.COLUMN_NAME_NAME} TEXT, " +
                "${Contract.Pokemons.COLUMN_NAME_DESCRIPTION} TEXT, " +
                "${Contract.Pokemons.COLUMN_NAME_TYPE} TEXT," +
                "${Contract.Pokemons.COLUMN_NAME_FAV} INTEGER, " +
                "${Contract.Pokemons.COLUMN_NAME_ABILITY} TEXT, " +
                "${Contract.Pokemons.COLUMN_NAME_HEIGHT} FLOAT, " +
                "${Contract.Pokemons.COLUMN_NAME_WEIGHT} FLOAT, " +
                "${Contract.Pokemons.COLUMN_NAME_IMAGE} BLOB)"
        db?.execSQL(createPokemons)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        if (oldVersion < 2) {
            db?.transaction {
                execSQL("ALTER TABLE ${Contract.Pokemons.TABLE_NAME} RENAME TO temp_pokemons")
                execSQL("""
                CREATE TABLE ${Contract.Pokemons.TABLE_NAME} (
                    _id INTEGER PRIMARY KEY AUTOINCREMENT,
                    ${Contract.Pokemons.COLUMN_NAME_IMAGE} BLOB
                )
            """)
                execSQL("""
                INSERT INTO ${Contract.Pokemons.TABLE_NAME} (_id, ${Contract.Pokemons.COLUMN_NAME_IMAGE})
                SELECT _id, ${Contract.Pokemons.COLUMN_NAME_IMAGE} FROM temp_pokemons
            """)
                execSQL("DROP TABLE temp_pokemons")
            }
        } else {
            db?.execSQL("DROP TABLE IF EXISTS ${Contract.Pokemons.TABLE_NAME}")
            onCreate(db)
        }
    }

    companion object{
        private const val DATABASE_NAME= "pokedex.db"
        private const val DATABASE_VERSION = 1
    }
}