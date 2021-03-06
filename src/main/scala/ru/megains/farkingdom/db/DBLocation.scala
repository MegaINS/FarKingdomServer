package ru.megains.farkingdom.db

import anorm.SQL
import ru.megains.farkingdom.Parsers

object DBLocation extends Database {


//    def load():  mutable.HashMap[Int,Location] ={
//       val locationsMap = new mutable.HashMap[Int,Location]()
//
//        withConnection(implicit c=> {
//            val locations = SQL("SELECT * FROM location ").as(Parsers.location *)
//            for (loc <- locations) {
//                locationsMap += loc.id -> new Location(loc)
//            }
//        })
//
//        locationsMap
//    }

    def loadObjects(): List[(Int,Int,String,Int)] ={
        withConnection(implicit c=> {
            SQL("SELECT * FROM loc_object ").as(Parsers.loc_object *)
        })
    }
}
