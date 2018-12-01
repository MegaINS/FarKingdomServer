package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.World
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class SPacketWorldLoad(val world:World) extends PacketWrite{



    override def writePacketData(buf: PacketBufferS): Unit = {

        buf.writeInt(world.x)
        buf.writeInt(world.y)
        buf.writeInt(world.map.size)

        world.map.foreach {
            case (index, value) =>
            buf.writeInt(index)
            buf.writeInt(value)
        }
    }
}
