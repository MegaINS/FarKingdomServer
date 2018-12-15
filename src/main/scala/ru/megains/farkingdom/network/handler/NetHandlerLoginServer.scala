package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.FKServer
import ru.megains.farkingdom.db.Database
import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.packet.login.{CPacketLoginStart, SPacketLoginSuccess}

class NetHandlerLoginServer(server: FKServer, networkManager: NetworkManager) extends INetHandlerLoginServer with Database {

    //var name: String = _

    override def processLoginStart(packetIn: CPacketLoginStart): Unit = {
        val login:String =  packetIn.login
        val pass:String = packetIn.pass
        println(s"login")



        server.playerList.players.find(_.login == login) match {
            case Some(value) =>
                networkManager.sendPacket(new SPacketLoginSuccess())
                server.playerList.initializeConnectionToPlayer(networkManager, value.id,login)
                println(s"login $login")
            case None =>
                println(s"Not player $login")
        }

//        withConnection(implicit c=>
//
//            SQL(s"SELECT * FROM player_auth WHERE login='$login'").as(Parsers.playerAuth.singleOpt).getOrElse(default = (0,"","")) match {
//
//                case (id,loginB,password) =>
//                    if (loginB == login && pass == password){
//                        networkManager.sendPacket(new SPacketLoginSuccess())
//                        server.playerList.initializeConnectionToPlayer(networkManager, id,login)
//                        println(s"login $login")
//                    }else{
//                        println(s"Not player $login")
//                    }
//            }
//
//        )
    }


    override def onDisconnect(msg: String): Unit = {

    }

    override def disconnect(msg: String): Unit = {

    }
}


