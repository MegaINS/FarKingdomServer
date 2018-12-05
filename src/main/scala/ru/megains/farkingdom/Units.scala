package ru.megains.farkingdom

import ru.megains.farkingdom.db.DBUnits

object Units {



    val units:Map[Int,BaseUnit] = DBUnits.load()

    def getWorldUnit(id: Int): WorldUnit = {
       val idCount:(Int,Int) = DBUnits.loadWorldUnit(id)

        new WorldUnit(units(idCount._1),idCount._2)
    }

}
