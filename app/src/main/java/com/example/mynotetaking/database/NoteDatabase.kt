package com.example.mynotetaking.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotetaking.model.Note

//569
@Database(entities = [Note::class] , version = 1)
abstract class NoteDatabase: RoomDatabase() {

    val INSTANCE = NoteDatabase::class

    abstract fun getNoteDao(): NoteDAO


    companion object{
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatbase(context).also{
                instance = it
            }
        }

        private fun createDatbase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"
            ).build()


    }
}