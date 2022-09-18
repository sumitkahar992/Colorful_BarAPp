package com.example.colorful_bar.firstunittest

import org.junit.Test

import org.junit.Assert.*


private val engine = Engine(2000,189,15,false)

class EngineTest {

    @Test
    fun engineTurnsOn() {
        engine.turnOn()


        assertEquals(true, engine.isTurnedOn)
        assertEquals(95, engine.temperature)

    }

    @Test
    fun engineTurnsOff(){
        engine.turnOn()

        engine.turnOff()


        assertEquals(false, engine.isTurnedOn)
        assertEquals(15, engine.temperature)
    }
}