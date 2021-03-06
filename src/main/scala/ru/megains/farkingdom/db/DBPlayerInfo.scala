package ru.megains.farkingdom.db

import anorm.SQL
import ru.megains.farkingdom.{Parsers, Player}


object DBPlayerInfo extends Database {


//
//    def load(player: Player): PlayerInfo = {
//        withConnection(implicit c =>
//            SQL(s"SELECT * FROM player_info WHERE id='${player.id}'").as(Parsers.playerInfo.single)
//        )
//    }


    def updateLocation(playerId:Int,locationId:Int): Unit ={
        withConnection(implicit c =>
            SQL(s"UPDATE player_info SET location='$locationId' WHERE id='$playerId'").execute()
        )
    }

        def load(): List[Player] = {
            withConnection(implicit c =>
                SQL(s"SELECT * FROM player_auth").as(Parsers.player *)
            )
        }
}
