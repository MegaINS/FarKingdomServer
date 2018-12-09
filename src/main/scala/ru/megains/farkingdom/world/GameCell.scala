package ru.megains.farkingdom.world

import ru.megains.farkingdom.{Army, Player}

class GameCell(val xPos:Int,val yPos:Int,val tile:String) {



    var player:Player = _
    var army:Army = _


    def enter(armyIn: Army): Boolean ={
        if(army == null){
            army = armyIn
            army.posX = xPos
            army.posY = yPos
            true
        }else{
            false
        }
    }
    def exit(): Boolean ={
        army ==null
    }

    def addPlayer(playerIn: Player): Boolean = {
        if(player == null && army == null){
            player = playerIn
            player.x = xPos
            player.y = yPos
            true
        }else{
            false
        }
    }

    def removePlayer(): Unit = {
        player = null
    }
}
