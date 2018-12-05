package ru.megains.farkingdom

import ru.megains.farkingdom.network.NetworkSystem
import ru.megains.farkingdom.world.World

class FKServer extends Logger [FKServer]{



    var playerList:PlayerList = _


    var isRunner: Boolean = true


    var world:World = _

    val networkSystem = new NetworkSystem(this)

    def start(): Boolean ={
        world = new World(this)
        world.createMap()

        playerList = new PlayerList(this)
        log.info("Start NetworkSystem")
        networkSystem.startLan(null,8080)

        true
    }




    def run(): Unit ={

        log.info("Server start")

        if(start()){
            log.info("Server run")
            while (isRunner){


                Thread.sleep(10)

            }


        }

        log.info("Server stop")
    }

}
