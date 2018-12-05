package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.PlayerAction
import ru.megains.farkingdom.PlayerAction._
import ru.megains.farkingdom.PlayerAction.PlayerAction
import ru.megains.farkingdom.network.handler.NetHandlerPlayServer
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}



class SPlayerAction extends PacketRead[NetHandlerPlayServer]{

    var playerAction:PlayerAction = _
    var par1:Int = 0
    var par2:Int = 0
    var par3:Int = 0
    var par4:String = ""

    override def readPacketData(buf: PacketBufferS): Unit = {
        playerAction = PlayerAction(buf.readInt())
        playerAction match {
            case MOVE|MINE =>
                par1 = buf.readInt()
                par2 =  buf.readInt()
//            case CHANGE_LOC =>
//                par4 = buf.readStringFromBuffer(255)
            case _=>
        }
    }



    override def processPacket(handler: NetHandlerPlayServer): Unit = {
        handler.playerAction(this)
    }
}
