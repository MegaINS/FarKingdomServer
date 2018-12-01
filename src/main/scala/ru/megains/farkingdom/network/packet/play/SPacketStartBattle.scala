package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketStartBattle(id:Int) extends PacketWrite{


//    override def readPacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def writePacketData(buf: PacketBufferS): Unit = {
        buf.writeInt(id)
    }

//    override def processPacket(handler: Nothing): Unit = {
//
//    }
}
