package ru.megains.farkingdom.network.packet.play


import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketLocInfo(/*loc:Location*/) extends PacketWrite{



//    override def readPacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def writePacketData(buf: PacketBufferS): Unit = {
      //  loc.write(buf)
    }

//    override def processPacket(handler: Nothing): Unit = {
//
//    }
}
