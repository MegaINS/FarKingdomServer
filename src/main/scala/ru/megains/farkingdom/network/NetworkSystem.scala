package ru.megains.farkingdom.network

import java.net.InetAddress

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.{ChannelFuture, EventLoopGroup}
import ru.megains.farkingdom.FKServer
import ru.megains.farkingdom.network.protocol.WoDChannelInitializer


class NetworkSystem(server: FKServer) {

    var networkServer: ServerBootstrap = _
    var channelFuture: ChannelFuture = _


    def startLan(address: InetAddress, port: Int): Unit = {
        val bossExec: EventLoopGroup = new NioEventLoopGroup(0)

        networkServer = new ServerBootstrap()
                .group(bossExec)
                .localAddress(address, port)
                .channel(classOf[NioServerSocketChannel])
                .childHandler(new WoDChannelInitializer(server))
        channelFuture = networkServer.bind.syncUninterruptibly()
      //  channelFuture.channel().closeFuture().sync()

    }

//    def networkTick() {
//
//        NetworkSystem.networkManagers = NetworkSystem.networkManagers.flatMap(
//            (networkManager) => {
//
//                if (!networkManager.hasNoChannel) {
//                    if (networkManager.isChannelOpen) {
//
//                        try {
//                            networkManager.processReceivedPackets()
//                        } catch {
//                            case exception: Exception =>
//                                exception.printStackTrace()
//                        }
//                        Some(networkManager)
//                    } else {
//                        networkManager.checkDisconnected()
//                        None
//                    }
//                } else {
//                    Some(networkManager)
//                }
//
//            }
//
//        )
//
//    }


}

//object NetworkSystem {
//    var networkManagers: ArrayBuffer[NetworkManager] = new ArrayBuffer[NetworkManager]
//}
