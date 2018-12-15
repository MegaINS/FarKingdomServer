package ru.megains.farkingdom

import ru.megains.farkingdom.db.DBUnits

object Units {



    var units:Map[Int,BaseUnit] = _

    def getWorldUnit(id: Int): WorldUnit = {
       val idCount:(Int,Int) = DBUnits.loadWorldUnit(id)

        new WorldUnit(units(idCount._1),idCount._2)
    }

}
