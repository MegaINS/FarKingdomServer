package ru.megains.farkingdom.network.packet.battle

import ru.megains.farkingdom.network.handler.NetHandlerBattleServer
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

class PBattleStatus extends PacketRead[NetHandlerBattleServer]{

        var id:Int = -1
    var status:Int = -1
    override def readPacketData(buf: PacketBufferS): Unit = {
        id = buf.readInt()
        status = buf.readByte()
    }

//    override def writePacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def processPacket(handler: NetHandlerBattleServer): Unit = {
        handler.processBattleStatus(this)
    }
}
