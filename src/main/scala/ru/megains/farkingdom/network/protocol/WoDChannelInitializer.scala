package ru.megains.farkingdom.network.protocol

import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.{ChannelInitializer, ChannelOption}
import ru.megains.farkingdom.FKServer
import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.handler.NetHandlerHandshakeTCP


class WoDChannelInitializer(server:FKServer) extends ChannelInitializer[NioSocketChannel]{


    override def initChannel(ch: NioSocketChannel): Unit = {
        val networkManager = new NetworkManager(server)
        ch.pipeline()
                .addLast("serverCodec", new WoDServerCodec)
                .addLast("messageCodec", new WoDMessageCodec)
                .addLast("packetHandler", networkManager)
        ch.config.setOption(ChannelOption.TCP_NODELAY, Boolean.box(true))


       // NetworkSystem.networkManagers :+= networkManager

        networkManager.setNetHandler(new NetHandlerHandshakeTCP(server, networkManager))
    }
}
