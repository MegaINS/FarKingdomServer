package ru.megains.farkingdom.network.packet.play


import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketBodyUpdate(/*slot:SlotType,item:ItemUser*/) extends PacketWrite {


    override def writePacketData(buf: PacketBufferS): Unit = {
//
//        buf.writeByte(slot.id)
//        val isNotNull = item!=null
//        buf.writeBoolean(isNotNull)
//        if(isNotNull){
//            buf.writeItemUser(item)
//        }
    }

}
