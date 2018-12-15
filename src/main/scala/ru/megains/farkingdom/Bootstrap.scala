package ru.megains.farkingdom


object Bootstrap {




    def start(server: FKServer): Unit = {

        players(server)
        unit(server)
        army(server)

    }

    def army(server: FKServer): Unit ={

        val armys = List.apply(
            new Army(){
                id =1
                posX = 5
                posY = 5
                name = "2"
                units(0) =  new WorldUnit(Units.units(2),45)
                units(1) =  new WorldUnit(Units.units(2),89)
            },
            new Army(){
                id =2
                posX = -4
                posY = 5
                name = "3"
                units(1) =  new WorldUnit(Units.units(3),4)
                units(2) =  new WorldUnit(Units.units(4),78)
            },
            new Army(){
                id =3
                posX = 8
                posY = -7
                name = "4"
                units(0) =  new WorldUnit(Units.units(6),4564)
                units(1) =  new WorldUnit(Units.units(5),788)
                units(3) =  new WorldUnit(Units.units(7),122)
                units(4) =  new WorldUnit(Units.units(9),465)
            },
            new Army(){
                id =4
                posX = -5
                posY = -5
                name = "4"
                units(1) =  new WorldUnit(Units.units(8),456)
            }



        )


        armys.foreach { army =>
            val gameCell = server.world. map(server.world.getIndex(army.posX, army.posY))
            gameCell.army = army
        }
    }







    def players(server: FKServer): Unit = {
        server.playerList.players = List.apply(
            new Player(0, "Test_1") {
                x = 1
                y = 1
            },
            new Player(1, "Test_2") {
                x = -1
                y = -1
            },
            new Player(2, "Test_3") {
                x = -1
                y = 1
            },
            new Player(3, "Test_4") {
                x = 1
                y = -1
            }
        )
    }

    def unit(server: FKServer): Unit = {

        Units.units = Map.apply(
            0 -> new BaseUnit() {
                id = 1
                name = "0"
                level = 1
                hp = 100
                midDam = 2
                maxDam = 4
                power = 10
            },
            1 -> new BaseUnit() {
                id = 2
                name = "1"
                level = 1
                hp = 100
                midDam = 3
                maxDam = 4
                power = 100
            },
            2 -> new BaseUnit() {
                id = 3
                name = "2"
                level = 2
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            3 -> new BaseUnit() {
                id = 4
                name = "3"
                level = 3
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            4 -> new BaseUnit() {
                id = 5
                name = "4"
                level = 4
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            5 -> new BaseUnit() {
                id = 6
                name = "5"
                level = 5
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            6 -> new BaseUnit() {
                id = 7
                name = "6"
                level = 6
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            7 -> new BaseUnit() {
                id = 8
                name = "7"
                level = 7
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            8 -> new BaseUnit() {
                id = 9
                name = "8"
                level = 8
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            },
            9 -> new BaseUnit() {
                id = 9
                name = "9"
                level = 9
                hp = 200
                midDam = 5
                maxDam = 6
                power = 100
            }

        )
    }
}
