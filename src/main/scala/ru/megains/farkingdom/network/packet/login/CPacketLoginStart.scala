package ru.megains.farkingdom.network.packet.login

import ru.megains.farkingdom.network.handler.INetHandlerLoginServer
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

class CPacketLoginStart extends PacketRead[INetHandlerLoginServer] {


    var login: String = ""
    var pass: String = ""

    override def readPacketData(packetBuffer: PacketBufferS): Unit = {
        login = packetBuffer.readStringFromBuffer(255)
        pass = packetBuffer.readStringFromBuffer(255)
    }


    override def processPacket(handler: INetHandlerLoginServer): Unit = {
        handler.processLoginStart(this)
    }
}
