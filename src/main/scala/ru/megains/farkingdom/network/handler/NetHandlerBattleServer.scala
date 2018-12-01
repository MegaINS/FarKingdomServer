package ru.megains.farkingdom.network.handler


import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.packet.Packet
import ru.megains.farkingdom.network.packet.battle.PBattleStatus
import ru.megains.farkingdom.{FKServer, Logger}

class NetHandlerBattleServer(server: FKServer, networkManager: NetworkManager) extends INetHandler with Logger[NetHandlerBattleServer]{




    def processBattleStatus(packet: PBattleStatus): Unit = {

        packet.status match {
            case 1 =>
             //  val battle = BattleList.get(packet.id)
              //  battle.status = 1
             //   battle.sendAllStart()

            case 2 =>

            case _ =>  log.info(s"Error Battle Status ${packet.status}")
        }


    }






    override def sendPacket(packetIn: Packet[_ <: INetHandler]) {

        try
            networkManager.sendPacket(packetIn)

        catch {
            case throwable: Throwable =>
                log.error("sendPacket", throwable)
        }
    }

    override def onDisconnect(msg: String): Unit = {
        log.info("{} lost connection: {}", Array[AnyRef]("Battle Server", msg))
    }

    override def disconnect(msg: String): Unit = {
        log.info("{} lost connection: {}", Array[AnyRef]("Battle Server", msg))
    }
}
