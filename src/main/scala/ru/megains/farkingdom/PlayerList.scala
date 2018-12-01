package ru.megains.farkingdom

import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.handler.NetHandlerPlayServer
import ru.megains.farkingdom.network.packet.play.SPacketWorldLoad

import scala.collection.mutable.ArrayBuffer

class PlayerList(val server:FKServer) {


    val players = new ArrayBuffer[Player]()





    def initializeConnectionToPlayer(networkManager: NetworkManager, id: Int, login: String): Unit = {



        val player = new Player(id,login)
        networkManager.setNetHandler( new NetHandlerPlayServer(server))
        player.connection = networkManager

        player.connection.sendPacket(new SPacketWorldLoad(server.world))
        playerLoggedIn(player)
    }

    def playerLoggedIn(player: Player) {
        players+= player
       // nameToPlayerMap += player.name -> playerIn
        //sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, Array[EntityPlayerMP](playerIn)))
        val worldserver: World = server.world


      //  worldserver.spawnEntityInWorld(player)
        preparePlayer(player, null)
    }

    def preparePlayer(playerIn: Player, worldIn: World) {
        val worldserver: World = playerIn.world
       // if (worldIn != null) worldIn.playerManager.removePlayer(playerIn)
       // worldserver.playerManager.addPlayer(playerIn)
      //  worldserver.chunkProvider.provideChunk(playerIn.posX.toInt >> 8, playerIn.posY.toInt >> 8, playerIn.posZ.toInt >> 8)
    }
}
