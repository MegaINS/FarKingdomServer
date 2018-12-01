package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.{FKServer, Logger}
import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.packet.CHandshake
import ru.megains.farkingdom.network.packet.ConnectionState._

class NetHandlerHandshakeTCP(server: FKServer, networkManager: NetworkManager) extends INetHandlerHandshakeServer with Logger[NetHandlerHandshakeTCP]{


    override def processHandshake(packetIn: CHandshake): Unit = {

        packetIn.connectionState match {
            case LOGIN =>
                networkManager.setConnectionState(LOGIN)
                networkManager.setNetHandler(new NetHandlerLoginServer(server, networkManager))

            case STATUS =>
                networkManager.setConnectionState(STATUS)

            case BATTLE_SERVER =>
                networkManager.setConnectionState(BATTLE_SERVER)
                networkManager.setNetHandler(new NetHandlerBattleServer(server, networkManager))
              //  server.battleServer = networkManager
                log.info("Connect Battle server")
            case _ =>
                throw new UnsupportedOperationException("Invalid intention " + packetIn.connectionState)
        }
    }

    override def onDisconnect(msg: String): Unit = {

    }

    override def disconnect(msg: String): Unit = {

    }
}
