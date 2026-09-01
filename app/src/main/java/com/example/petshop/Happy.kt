package com.example.petshop

class Happy (date: String): Mood(date){
    override fun showMood(): String {
        return "Mood: Happy, date of the recorded mood: $date"
    }
}