package ru.megains.farkingdom.network.packet.play


import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketSlotUpdate(/*slotType: SlotType, item:ItemUser = null*/) extends PacketWrite{


    override def writePacketData(buf: PacketBufferS): Unit = {
//        buf.writeInt(slotType.id)
//        val isNotNull = item!=null
//        buf.writeBoolean(isNotNull)
//        if(isNotNull){
//            buf.writeItemUser(item)
//        }

    }
}
