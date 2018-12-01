package ru.megains.farkingdom.network.packet.play



import ru.megains.farkingdom.network.handler.INetHandlerPlayServer
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

class CPacketAction extends PacketRead[INetHandlerPlayServer]{
  //  var action:Action = _
    var id:Int = -1
    var value1:Int = -1
    var value2:Int = -1
    override def readPacketData(buf: PacketBufferS): Unit = {
       // action = Action(buf.readByte())
        id = buf.readInt()
        value1 = buf.readInt()
        value2 = buf.readInt()
    }

//    override def writePacketData(buf: PacketBuffer): Unit = {
//
//    }

    override def processPacket(handler: INetHandlerPlayServer): Unit = {
        handler.processAction(this)
    }
}
