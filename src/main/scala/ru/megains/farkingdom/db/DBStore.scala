package ru.megains.farkingdom.db

import anorm.SQL
import ru.megains.farkingdom.Parsers


object DBStore extends Database {



//    def loadStore(): List[Store] ={
//        withConnection(implicit c=> {
//            SQL(s"SELECT * FROM store").as(Parsers.store *)
//        })
//    }


//    def loadTab(): List[StoreTab] ={
//        withConnection(implicit c=> {
//            SQL(" SELECT * FROM store_tab").as(Parsers.storeTab *)
//        })
//    }
    def loadTabIdItemId(): List[(Int,Int)] ={
        withConnection(implicit c=> {
            SQL(" SELECT * FROM store_tab_item_base").as(Parsers.storeTabItemBase *)
        })
    }
    def loadStoreIdTabId(): List[(Int,Int)] ={
        withConnection(implicit c=> {
            SQL(" SELECT * FROM store_store_tab").as(Parsers.storeStoreTab *)
        })
    }

}
