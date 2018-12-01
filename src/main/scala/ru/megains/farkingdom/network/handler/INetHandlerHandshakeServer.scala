package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.network.packet.CHandshake

trait INetHandlerHandshakeServer extends INetHandler {


    def processHandshake(packet: CHandshake)
}
