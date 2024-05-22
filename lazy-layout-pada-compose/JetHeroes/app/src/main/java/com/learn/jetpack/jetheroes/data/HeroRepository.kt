package com.learn.jetpack.jetheroes.data

import com.learn.jetpack.jetheroes.model.Hero
import com.learn.jetpack.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}