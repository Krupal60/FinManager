package com.krupal.finmanager.data

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class HomeModel: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var TotalBalance:Int = 0
    var Cash: Cash? = null
    var Card: Card? = null
    var Savings:Savings? = null
}

class Card: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var TotalAmount:Int = 0
    var CardData: CardData? = null
}
class Cash: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var TotalAmount:Int = 0
    var CashData: CashData? = null
}

class Savings: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var TotalAmount:Int = 0
    var CardData: SavingsData? = null
}

class CardData: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var Amount:Int = 0
}

class CashData: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var Amount:Int = 0
}
class SavingsData: RealmObject{
    @PrimaryKey var Id : ObjectId = ObjectId()
    var Amount:Int = 0
}
