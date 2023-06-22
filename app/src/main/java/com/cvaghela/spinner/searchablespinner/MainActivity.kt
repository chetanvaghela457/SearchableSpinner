package com.cvaghela.spinner.searchablespinner

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.cvaghela.spinner.searchablespinner.interfaces.OnItemSelectedListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    lateinit var searchableSpinner: SearchableSpinner
    lateinit var searchableSpinner1: SearchableSpinner
    lateinit var searchableSpinner2: SearchableSpinner
    lateinit var searchableSpinner3: SearchableSpinner

    lateinit var adapter: SimpleArrayListAdapter
    lateinit var adapterTag: SimpleArrayWithTagAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchableSpinner = findViewById(R.id.searchableSpinner)
        searchableSpinner1 = findViewById(R.id.searchableSpinner1)
        searchableSpinner2 = findViewById(R.id.searchableSpinner2)
        searchableSpinner3 = findViewById(R.id.searchableSpinner3)

        getListData().observeForever {

            if (it.size > 0) {

                adapter = SimpleArrayListAdapter(this, it)
                adapterTag = SimpleArrayWithTagAdapter(this, it)
                searchableSpinner.setAdapter(adapter)
                searchableSpinner.setOnItemSelectedListener(object : OnItemSelectedListener {
                    override fun onItemSelected(view: View?, position: Int, id: Long) {
                        Toast.makeText(
                            this@MainActivity,
                            "Item on position " + position + " : " + adapter.getItem(
                                position
                            ) + " Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected() {
                        Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT)
                            .show()
                    }

                })


                searchableSpinner1.setAdapter(adapter)
                searchableSpinner1.setOnItemSelectedListener(object : OnItemSelectedListener {
                    override fun onItemSelected(view: View?, position: Int, id: Long) {
                        Toast.makeText(
                            this@MainActivity,
                            "Item on position " + position + " : " + adapter.getItem(
                                position
                            ) + " Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected() {
                        Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT)
                            .show()
                    }

                })

                searchableSpinner2.setAdapter(adapterTag)
                searchableSpinner2.setOnItemSelectedListener(object : OnItemSelectedListener {
                    override fun onItemSelected(view: View?, position: Int, id: Long) {
                        Toast.makeText(
                            this@MainActivity,
                            "Item on position " + position + " : " + adapterTag.getItem(
                                position
                            ) + " Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected() {
                        Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT)
                            .show()
                    }

                })

                searchableSpinner3.setAdapter(adapter)
                searchableSpinner3.setOnItemSelectedListener(object : OnItemSelectedListener {
                    override fun onItemSelected(view: View?, position: Int, id: Long) {
                        Toast.makeText(
                            this@MainActivity,
                            "Item on position " + position + " : " + adapter.getItem(
                                position
                            ) + " Selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected() {
                        Toast.makeText(this@MainActivity, "Nothing Selected", Toast.LENGTH_SHORT)
                            .show()
                    }

                })

            }

        }

    }


    fun getListData(): MutableLiveData<ArrayList<String>> {
        val encodedString = MutableLiveData<ArrayList<String>>()

        val jsonFileString = getJsonDataFromRaw(
            this,
            R.raw.array_item
        )
        val type = object : TypeToken<ArrayList<String>>() {}.type
        encodedString.postValue(Gson().fromJson(jsonFileString, type))

        return encodedString
    }
}