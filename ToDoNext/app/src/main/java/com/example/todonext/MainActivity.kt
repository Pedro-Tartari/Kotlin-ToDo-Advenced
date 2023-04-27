package com.example.todonext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todonext.databinding.ActivityMainBinding
import com.example.todonext.model.Item
import com.example.todonext.room.ToDoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appDb: ToDoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDb = ToDoDatabase.getDatabase(this) // chama o BD

        binding.btnAdd.setOnClickListener {
            writeData()
        }

    }

    private fun writeData(){
        var name = binding.etItem.text.toString()

        if(name.isNotEmpty() ) {
            val itemObj = Item(
                null, name, false
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.itemDao().insertItem(itemObj)
            }

            binding.etItem.text.clear()


            Toast.makeText(this@MainActivity,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@MainActivity,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }
}