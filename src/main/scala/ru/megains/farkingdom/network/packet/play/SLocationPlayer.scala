package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.LocAction.LocAction
import ru.megains.farkingdom.Player
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}


class SLocationPlayer(action:LocAction, player: Player,i:Boolean) extends PacketWrite{


    override def writePacketData(buf: PacketBufferS): Unit = {
        buf.writeInt(action.id)
        buf.writeInt(player.id)
        buf.writeBoolean(i)
        buf.writeInt(player.x)
        buf.writeInt(player.y)

    }


}
