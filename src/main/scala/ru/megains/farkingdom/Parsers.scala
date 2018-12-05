package ru.megains.farkingdom

import anorm.SqlParser.get
import anorm.{RowParser, ~}

object Parsers {
    val worldUnit: RowParser[(Int,Int)] = {
        get[Int]("unitid") ~
                    get[Int]("count") map{
                case unitid~count =>(unitid,count)
        }
    }

    val army: RowParser[Army] = {
        get[Int]("id") ~
                get[Int]("xpos") ~
                get[Int]("ypos") ~
                get[String]("name")~
                get[Int]("unit1").? ~
                get[Int]("unit2").? ~
                get[Int]("unit3").? ~
                get[Int]("unit4").? ~
                get[Int]("unit5").? map{
            case idIn~xpos~ypos~nameIn~unit1~unit2~unit3~unit4~unit5 =>
                val army =new Army(){
                    id = idIn
                    posX =xpos
                    posY = ypos
                    name = nameIn
                    unit1 match {
                        case Some(value) =>
                            units(0) = Units.getWorldUnit(value)
                        case None =>
                    }
                    unit2 match {
                        case Some(value) =>
                            units(1) = Units.getWorldUnit(value)
                        case None =>
                    }
                    unit3 match {
                        case Some(value) =>
                            units(2) = Units.getWorldUnit(value)
                        case None =>
                    }
                    unit4 match {
                        case Some(value) =>
                            units(3) = Units.getWorldUnit(value)
                        case None =>
                    }
                    unit5 match {
                        case Some(value) =>
                            units(4) = Units.getWorldUnit(value)
                        case None =>
                    }
                }
                army

        }
    }

    val player : RowParser[Player] = {
        get[Int]("id") ~
                get[String]("login")~
                get[Int]("xpos") ~
                get[Int]("ypos") map{
            case id~login~xpos~ypos =>new Player(id,login){
                x = xpos
                y = ypos
            }
        }
    }

    //    val itemParam : RowParser[(ItemParam,Int)] = {
//        get[String]("param") ~
//                get[Int]("value")  map{
//            case param~value =>(ItemParam.withName(param) ,value)
//        }
//    }
//
//    var playerStat:RowParser[(EntityStat,Int)] ={
//        get[String]("stat") ~
//                get[Int]("value")map{
//            case stat~value =>(EntityStat.withName(stat) ,value)
//        }
//
//
//    }

    val baseUnit : RowParser[BaseUnit] = {
        get[Int]("id") ~
                get[String]("name") map{
            case id~name =>new BaseUnit(id,name)
        }
    }



    var loc_object : RowParser[(Int,Int,String,Int)] = {
        get[Int]("id") ~
                get[Int]("loc_id") ~
                get[String]("object_type") ~
                get[Int]("object_id") map{
            case id~locId~objectType~objectId =>(id,locId,objectType,objectId)
        }
    }

    var loc_store: RowParser[(Int,Int,Int)] = {
        get[Int]("id") ~
                get[Int]("loc_id") ~
                get[Int]("store_id") map{
            case id~id1~id2 =>(id,id1,id2)
        }
    }

    val storeStoreTab: RowParser[(Int,Int)] = {
        get[Int]("store_id") ~
                get[Int]("store_tab_id")  map{
            case storeId~tabId =>(storeId,tabId)
        }
    }

    var storeTabItemBase : RowParser[(Int,Int)] = {
        get[Int]("store_tab_id") ~
        get[Int]("item_base_id")  map{
            case tabId~iremId =>(tabId,iremId)
        }
    }

    val loc_loc: RowParser[(Int,Int,Int)] = {
        get[Int]("id") ~
        get[Int]("loc_id_1") ~
        get[Int]("loc_id_2") map{
            case id~id1~id2 =>(id,id1,id2)
        }
    }


//    val itemBase: RowParser[ItemBase] = {
//        get[Int]("id") ~
//        get[String]("name") ~
//        get[String]("img") ~
//        get[Int]("level") ~
//        get[Int]("cost") ~
//        get[Boolean]("weight") ~
//        get[Boolean]("private")~
//        get[String]("action")~
//        get[String]("slot")~
//        get[Boolean]("stack")map{
//            case id~name~img~level~cost~weight~privat~action~slot~stack => new ItemBase(id,name,img,level,cost,weight,privat,ItemAction.withName(action),SlotType.withName(slot),stack )
//        }
//    }
//
//    val itemUser: RowParser[ItemUser]={
//        get[Int]("id")~
//        get[Int]("item_id")~
//        get[Int]("amount")map{
//            case id~baseId~amount => new ItemUser(id,baseId,amount)
//        }
//    }


    val itemsBackpackId: RowParser[Array[Int]]={
        get[String]("items") map (items => items.split("_").map((s) => Integer.parseInt(s)))
    }

//    val location: RowParser[LocInfo] = {
//        get[Int]("id") ~
//        get[String]("name") map{
//            case id~name =>LocInfo(id,name)
//        }
//    }
//
//    val body: RowParser[Map[SlotType, Int]] ={
//
//        get[Int]("head") ~
//        get[Int]("gloves") ~
//        get[Int]("leggings") ~
//        get[Int]("boots") ~
//        get[Int]("hauberk") ~
//        get[Int]("belt") ~
//        get[Int]("cuirass") ~
//        get[Int]("shoulders")~
//        get[Int]("leftHand") ~
//        get[Int]("rightHand") map{
//
//            case  head~gloves~leggings~boots~hauberk~belt~cuirass~shoulders~leftHand~rightHand =>
//
//                HashMap[SlotType,Int](
//                 SlotType.head -> head,
//                 SlotType.gloves ->gloves,
//                 SlotType.leggings ->leggings,
//                 SlotType.boots ->boots,
//                 SlotType.hauberk ->hauberk,
//                 SlotType.belt ->belt,
//                 SlotType.cuirass ->cuirass,
//                 SlotType.shoulders ->shoulders,
//                 SlotType.leftHand ->leftHand,
//                 SlotType.rightHand ->rightHand
//            )
//        }
//
//
//    }
//
//    val storeTab: RowParser[StoreTab] = {
//        get[Int]("id")~
//        get[String]("name") map{
//            case id~name => new StoreTab(id,name)
//        }
//    }
//
//    val store: RowParser[Store] = {
//        get[Int]("id")~
//        get[String]("name")map{
//            case id~name => new Store(id,name)
//        }
//    }

    val playerAuth: RowParser[(Int, String, String)] = {
        get[Int]("id") ~
                get[String]("login") ~
                get[String]("password") map{
            case id~login~password => (id,login,password)
        }
    }

//    val playerInfo: RowParser[PlayerInfo] = {
//        get[Int]("id") ~
//        get[Int]("level") ~
//        get[Int]("exp") ~
//        get[Int]("location") ~
//        get[Int]("money") map{
//            case id~level~exp~loc~money =>new PlayerInfo(id,level,exp,loc,money)
//        }
//    }

//    val playerSlot: RowParser[Array[Int]] = {
//        get[Int]("slot_1") ~
//        get[Int]("slot_2") ~
//        get[Int]("slot_3") ~
//        get[Int]("slot_4") ~
//        get[Int]("slot_5") ~
//        get[Int]("slot_6") ~
//        get[Int]("slot_7") ~
//        get[Int]("slot_8") ~
//        get[Int]("slot_9") ~
//        get[Int]("slot_10") map{
//            case item0~item1~item2~item3~item4~item5~item6~item7~item8~item9 =>
//                Array(item0,item1,item2,item3,item4,item5,item6,item7,item8,item9)
//        }
//    }

//    val playerSlot: RowParser[Map[SlotType, Int]] ={
//
//        get[Int]("slot_1") ~
//                get[Int]("slot_2") ~
//                get[Int]("slot_3") ~
//                get[Int]("slot_4") ~
//                get[Int]("slot_5") ~
//                get[Int]("slot_6") ~
//                get[Int]("slot_7") ~
//                get[Int]("slot_8") ~
//                get[Int]("slot_9") ~
//                get[Int]("slot_10") map{
//
//            case  item1~item2~item3~item4~item5~item6~item7~item8~item9~item10 =>
//
//                HashMap[SlotType,Int](
//                    SlotType.elixir1 ->item1,
//                    SlotType.elixir2 ->item2,
//                    SlotType.elixir3 ->item3,
//                    SlotType.elixir4 ->item4,
//                    SlotType.elixir5 ->item5,
//                    SlotType.elixir6 ->item6,
//                    SlotType.elixir7 ->item7,
//                    SlotType.elixir8 ->item8,
//                    SlotType.elixir9 ->item9,
//                    SlotType.elixir10 ->item10
//                )
//        }
//
//
//    }


//
//    val mob: RowParser[Mob] = {
//        get[Int]("id") ~
//        get[String]("name") ~
//        get[Int]("level")map{
//            case id~name~level => new Mob(id, name, level)
//        }
//    }






}
