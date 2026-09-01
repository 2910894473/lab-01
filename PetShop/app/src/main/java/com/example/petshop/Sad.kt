package com.example.petshop

class Sad (date: String): Mood(date){
    override fun showMood(): String {
        return "Sad, date of the recorded mood: $date"
    }
}