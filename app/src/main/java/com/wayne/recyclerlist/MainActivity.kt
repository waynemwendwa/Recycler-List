package com.wayne.recyclerlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.bloco.faker.Faker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val faker = Faker()
        val peopleList = arrayListOf<Person>()

        for (i in 1..50) {
            val name = faker.name.firstName() + " " + faker.name.lastName()
            val email = faker.internet.email(name)
            val address = faker.address.streetAddress()
            val age = faker.number.between(18,75)
            val phone = faker.phoneNumber.phoneNumber()
            //Log.d("FAKER", "$name : $email : $address : $age : $phone")

            val person = Person(name,email,address,age,phone)
            peopleList.add(person)

        }
        val recyclerPeople : RecyclerView = findViewById(R.id.recyclerView)
        recyclerPeople.layoutManager = LinearLayoutManager(this)
         val adapter = CustomAdapter(peopleList)
        recyclerPeople.adapter = adapter


    }
}