package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.network.packet.login.CPacketLoginStart

trait INetHandlerLoginServer extends INetHandler {

    def processLoginStart(packetIn: CPacketLoginStart)

    //  def processEncryptionResponse(packetIn: CPacketEncryptionResponse)
}
