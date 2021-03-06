package ru.megains.farkingdom.network.packet

import ru.megains.farkingdom.network.packet.battle.{PBattleStatus, PCreateBattle}
import ru.megains.farkingdom.network.packet.login.{CPacketLoginStart, SPacketDisconnect, SPacketLoginSuccess}
import ru.megains.farkingdom.network.packet.play._

import scala.collection.mutable


sealed abstract class ConnectionState(val name: String, val id: Int) {


    val serverIdPacket = new mutable.HashMap[ Class[_ <: PacketWrite],Int]()
    val clientPacketId = new mutable.HashMap[Int,Class[_ <: PacketRead[_]]]()


    def registerServerPacket(packet: Class[_ <: PacketWrite]): Unit = {
        serverIdPacket +=  packet -> serverIdPacket.size
    }
    def registerClientPacket(packet: Class[_ <: PacketRead[_]]): Unit = {
        clientPacketId += clientPacketId.size -> packet
    }
    def getServerPacketId(packet: Class[_ <: PacketWrite]): Option[Int] = {
        serverIdPacket.get(packet)
    }

    def getClientPacket(id: Int): Option[PacketRead[_]] = {
        clientPacketId(id) match {
            case null => None
            case packet => Some(packet.newInstance())
        }
    }

}


object ConnectionState {


    val STATES_BY_CLASS = new mutable.HashMap[Class[_ <: Packet[_]], ConnectionState]()

    def getFromId(id: Int): ConnectionState = {
        STATES_BY_ID(id)
    }


    def getFromPacket(inPacket: Packet[_]): ConnectionState = {
        STATES_BY_CLASS(inPacket.getClass)
    }


    case object HANDSHAKING extends ConnectionState("HANDSHAKING", 0) {
        registerServerPacket(classOf[SPacketDisconnect])
        registerClientPacket(classOf[CHandshake])
    }


    case object STATUS extends ConnectionState("STATUS", 1) {
        registerServerPacket(classOf[SPacketDisconnect])
    }

    case object LOGIN extends ConnectionState("LOGIN", 2) {
        registerServerPacket(classOf[SPacketDisconnect])
        registerServerPacket(classOf[SPacketLoginSuccess])


        registerClientPacket(classOf[CPacketLoginStart])

    }


    case object PLAY extends ConnectionState("PLAY", 3) {
        {
            registerServerPacket(classOf[SPacketDisconnect])
            registerServerPacket(classOf[SPacketWorldLoad])

           // registerServerPacket(classOf[SPacketLocInfo])
         //   registerServerPacket(classOf[CPlayerMove])
            registerServerPacket(classOf[SLocationPlayer])
            //registerServerPacket(classOf[SPacketPlayerInfo])
           // registerServerPacket(classOf[SLocUpdate])


            registerClientPacket(classOf[SPlayerAction])
//            registerServerPacket(classOf[SPacketPlayerInfo])
//            registerServerPacket(classOf[SPacketLocInfo])
//            registerServerPacket(classOf[SPacketInventory])
//            registerServerPacket(classOf[SPacketBody])
//            registerServerPacket(classOf[SPacketStore])
//            registerServerPacket(classOf[SPacketInvUpdate])
//            registerServerPacket(classOf[SPacketStartBattle])
//            registerServerPacket(classOf[SPacketPlayerLocation])
//            registerServerPacket(classOf[SPacketSlots])
//            registerServerPacket(classOf[SPacketSlotUpdate])
//
//            registerServerPacket(classOf[SPacketBodyUpdate])

        }

        {
            registerClientPacket(classOf[CPacketAction])
        }






    }
    case object BATTLE_SERVER extends ConnectionState("BATTLE_SERVER", 4) {
        //        registerServerPacket(classOf[SPacketDisconnect])
        //        registerServerPacket(classOf[SPacketPlayerInfo])
        //        registerServerPacket(classOf[SPacketLocInfo])
        //        registerServerPacket(classOf[SPacketInventory])
        //        registerServerPacket(classOf[SPacketBody])
        //        registerServerPacket(classOf[SPacketActionReturn])
        //        registerServerPacket(classOf[SPacketStore])
        //        registerServerPacket(classOf[SPacketInvUpdate])
        //
        //
        //        registerClientPacket(classOf[CPacketAction])
        registerServerPacket(classOf[PCreateBattle])


        registerClientPacket(classOf[PBattleStatus])

    }

    val STATES_BY_ID = Array(HANDSHAKING, STATUS, LOGIN, PLAY,BATTLE_SERVER)
    addClass(HANDSHAKING)
    addClass(STATUS)
    addClass(LOGIN)
    addClass(PLAY)
    addClass(BATTLE_SERVER)

    def addClass(state: ConnectionState): Unit = {
        state.clientPacketId.values.foreach(packet =>
            STATES_BY_CLASS += packet -> state)

        state.serverIdPacket.keySet.foreach(packet =>
            STATES_BY_CLASS += packet -> state)
    }


}
