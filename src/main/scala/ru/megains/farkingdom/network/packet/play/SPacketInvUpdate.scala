package ru.megains.farkingdom.network.packet.play


import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketInvUpdate(/*invType:InventoryType,itemsIn:Array[ItemUser],*/test:Byte) extends PacketWrite{


//    override def readPacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def writePacketData(buf: PacketBufferS): Unit = {
//        println( "SPacketInvUpdate "+test)
//        buf.writeByte(test)
//        buf.writeByte(invType.id)
//        buf.writeShort(itemsIn.length)
//        for (item <- itemsIn){
//            buf.writeItemUser(item)
//        }


    }

//    override def processPacket(handler: Nothing): Unit = {
//
//    }
}
