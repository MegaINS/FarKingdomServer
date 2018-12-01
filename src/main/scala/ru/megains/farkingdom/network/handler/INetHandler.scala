package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.network.packet.Packet

abstract class INetHandler {


    def onDisconnect(msg: String)

    def disconnect(msg: String)

    def sendPacket(packetIn: Packet[_ <: INetHandler]) {}

}
