package ru.megains.farkingdom

import scala.collection.mutable
import scala.util.Random


class World {


    val x = 50
    val y = 50
    val map = new mutable.HashMap[Int,Int]()


    def createMap(): Unit ={
        for(x <- -x to x;
            y <- -y to y){
            map(getIndex(x,y)) = Random.nextInt(2)
        }
    }
    def getIndex(x:Int,y:Int): Int ={
        (x & 65535) << 16 | (y & 65535)
    }
}
