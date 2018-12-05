package ru.megains.farkingdom.db

import anorm.SQL
import ru.megains.farkingdom.{BaseUnit, Parsers}

object DBUnits extends Database {
    def loadWorldUnit(id: Int): (Int,Int) = {
        withConnection(implicit c => {
           SQL(s"SELECT * FROM unit_world WHERE id=$id").as(Parsers.worldUnit single)
        })
    }


    def load():Map[Int,BaseUnit] = {
            withConnection(implicit c => {
              val list =   SQL(s"SELECT * FROM unit").as(Parsers.baseUnit *)
                list.map(l => l.id -> l) toMap
            })
        }

}
