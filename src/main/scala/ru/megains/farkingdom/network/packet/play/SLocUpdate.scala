package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}


class SLocUpdate( var par1:Int,var par2:Int) extends PacketWrite{




    override def writePacketData(buf: PacketBufferS): Unit = {
        buf.writeInt(par1)
        buf.writeInt(par2)
    }


}
