package ru.megains.farkingdom

import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.handler.INetHandler
import ru.megains.farkingdom.network.packet.Packet
import ru.megains.farkingdom.world.World

class Player(val id: Int, val login: String) {


    var world: World = _

    var x = 0
    var y = 0


    var connection: NetworkManager = _

    def sendPacket(packetIn: Packet[_ <: INetHandler]) {
        if (connection != null) {
            connection.sendPacket(packetIn)

        }
    }

}