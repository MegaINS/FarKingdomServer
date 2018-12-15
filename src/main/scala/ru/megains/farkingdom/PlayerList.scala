package ru.megains.farkingdom

import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.handler.NetHandlerPlayServer
import ru.megains.farkingdom.network.packet.play.{SLocationPlayer, SPacketWorldLoad}
import ru.megains.farkingdom.world.World

class PlayerList(val server: FKServer) {


    var players: List[Player] = _



    def initializeConnectionToPlayer(networkManager: NetworkManager, id: Int, login: String): Unit = {


        val player = players(id)

        networkManager.setNetHandler(new NetHandlerPlayServer(server, player))
        player.connection = networkManager

        player.sendPacket(new SPacketWorldLoad(server.world))
        playerLoggedIn(player)

    }

    def playerLoggedIn(player: Player) {
        // nameToPlayerMap += player.name -> playerIn
        //sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.ADD_PLAYER, Array[EntityPlayerMP](playerIn)))
        val worldserver: World = server.world

        players.foreach {
            p =>

                p.sendPacket(new SLocationPlayer(LocAction.ENTER, player, p.id == player.id))
                if(p.id!= player.id){
                    player.sendPacket(new SLocationPlayer(LocAction.ENTER, p, false))
                }

        }
       // worldserver.playerList += player.id -> player
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
