package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.network.packet.play.CPacketAction

trait INetHandlerPlayServer extends INetHandler {
    def processAction(action: CPacketAction): Unit


}
