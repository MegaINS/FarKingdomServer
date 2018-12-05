package ru.megains.farkingdom.db

import anorm.SQL
import ru.megains.farkingdom.{Army, Parsers}

object DBArmy extends Database {



    def load():List[Army] = {
        withConnection(implicit c => {
            SQL(s"SELECT * FROM army").as(Parsers.army *)
        })
    }



}
