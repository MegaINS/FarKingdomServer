package ru.megains.farkingdom.network.packet.play


import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketBody(/*body: PlayerBody*/) extends PacketWrite{


//    override def readPacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def writePacketData(buf: PacketBufferS): Unit = {
//        val bodyFilter = body.slots.filter{case(_,item)=> item != null }
//        buf.writeByte(bodyFilter.size)
//        bodyFilter.foreach{
//            case (slot,item)=>
//                buf.writeByte(slot.id)
//                buf.writeItemUser(item)
//        }
    }

//    override def processPacket(handler: Nothing): Unit = {
//
//    }
}
