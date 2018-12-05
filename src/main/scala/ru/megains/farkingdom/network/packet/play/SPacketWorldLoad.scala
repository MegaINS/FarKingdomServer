package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}
import ru.megains.farkingdom.world.World

class SPacketWorldLoad(val world:World) extends PacketWrite{



    override def writePacketData(buf: PacketBufferS): Unit = {

        buf.writeInt(world.x)
        buf.writeInt(world.y)
        buf.writeInt(world.map.size)

        world.map.foreach {
            case (index, value) =>
                buf.writeInt(index)
                buf.writeStringToBuffer(value.tile)

                buf.writeInt(value.xPos)
                buf.writeInt(value.yPos)
                buf.writeBoolean(value.army != null)


                if(value.army != null){
                    buf.writeStringToBuffer(value.army.name)

                    value.army.units.foreach(u=>if(u == null)  buf.writeInt(0) else  buf.writeInt(u.baseUnit.name.toInt))
                }
        }
    }
}
