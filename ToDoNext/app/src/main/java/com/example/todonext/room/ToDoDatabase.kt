package com.example.todonext.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todonext.model.Item

/*
*   a classe ToDoDatabase é usada para criar e gerenciar o banco de dados SQLite do aplicativo,
*   e a interface ItemDao define as operações de acesso aos dados que podem ser executadas no banco de dados.*/
@Database(
    entities = [Item::class],
    version = 1
)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun itemDao() : ItemDao

    companion object{

        @Volatile
        private var INSTANCE : ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    "item"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}
