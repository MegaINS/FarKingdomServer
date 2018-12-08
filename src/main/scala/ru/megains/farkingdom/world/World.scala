package ru.megains.farkingdom.world

import ru.megains.farkingdom.db.DBArmy
import ru.megains.farkingdom.network.packet.play.SLocationPlayer
import ru.megains.farkingdom.{FKServer, LocAction, Player}

import scala.collection.mutable


class World(val fkServer: FKServer) {

    val x = 50
    val y = 50
    val map = new mutable.HashMap[Int, GameCell]()


    def movePlayer(player: Player, x: Int, y: Int): Unit = {
        val gameCell1 = map(getIndex(player.x, player.y))
        val gameCell = map(getIndex(x, y))
        if (gameCell.addPlayer(player)) {
            gameCell1.removePlayer()
            fkServer.playerList.players.foreach(p => p.sendPacket(new SLocationPlayer(LocAction.MOVE, player, p.id == player.id)))
        }

    }


    def createMap(): Unit = {
        for (x <- -x to x;
             y <- -y to y) {

            val tile = if ((x+ y) % 2  != 0) "grass1" else "send1"

            val gameCell = new GameCell(x, y, tile)

            map(getIndex(x, y)) = gameCell


        }
        val armys = DBArmy.load()
        armys.foreach { army =>
            val gameCell = map(getIndex(army.posX, army.posY))
            gameCell.army = army
        }
    }

    def getIndex(x: Int, y: Int): Int = {
        (x & 65535) << 16 | (y & 65535)
    }
}
