package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.PlayerAction._
import ru.megains.farkingdom.network.packet.Packet
import ru.megains.farkingdom.network.packet.play.{CPacketAction, SPlayerAction}
import ru.megains.farkingdom.{FKServer, Logger, Player}

class NetHandlerPlayServer(server: FKServer, player: Player) extends INetHandlerPlayServer with Logger[NetHandlerPlayServer] {



 //   player.setConnection(this)


    override def sendPacket(packetIn: Packet[_ <: INetHandler]) {

//        try
//            networkManager.sendPacket(packetIn)
//
//        catch {
//            case throwable: Throwable =>
//                log.error("sendPacket", throwable)
//        }
    }


    def disconnect(msg: String): Unit ={
       // networkManager.disconnect(msg)
    }

    def playerAction(action: SPlayerAction): Unit = {
        action.playerAction match {
            case MOVE =>
                server.world.movePlayer(player, action.par1,action.par2)
            case _=>
        }

    }



    def processAction(packet: CPacketAction): Unit={
//        val id = packet.id
//        packet.action match {
//            case Action.moveToLcc =>
//                player.location().moveToLocation(id,player)
//            case Action.takeOff =>
//                player.takeOff(SlotType(id)/*,packet.value1*/)
//            case Action.take =>
//                player.take(id)
//            case Action.delete =>
//                player.backpack.deleteItem(id,-1000)
//            case Action.store =>
//                player.location().sendStore(id,player)
//            case Action.storeBuy =>
//                player.location().getStore(id).buyItem(packet.value1,packet.value2,player)
//            case Action.attack =>
//
//                val battleId = BattleList.createBattle(player,Mobs.getMob(packet.id).get)
//
//                server.battleServer.sendPacket(new PCreateBattle(battleId, player.id,EntityType.player,packet.id,EntityType.mob))
//
//
//            case _ => log.info(s"Error Action ${ packet.action}")
//        }
   }



    override def onDisconnect(msg: String): Unit = {
//
//        log.info("{} lost connection: {}", Array[AnyRef](player.name, msg))
//
   }







}
