package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}


class CPlayerMove(id:Int,posX: Int, posY: Int) extends PacketWrite{



    override def writePacketData(buf: PacketBufferS): Unit = {
        buf.writeInt(id)
        buf.writeInt(posX)
        buf.writeInt(posY)

    }


}
