package com.example.todonext.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.todonext.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao  {

    //  esse ira adicionar e se tiver igual ira atualizar
    @Upsert
    suspend fun insertItem(item: Item) //suspend faz com que ele trabalhe como Courotine, ou seja, em uma thread

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getItemOrderedByName(): Flow<List<Item>>


}