package com.example.infofootball.data

data class Player(val name: String, val number: Int, val position: String, val age: Int,
                  val match_played: Int, val goals: Int, val yellow_cards: Int,
                  val red_cards: Int, val image: String)