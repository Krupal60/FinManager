package com.krupal.finmanager.data

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class HomeModel : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var totalBalance: Int = 0
    var account: Account? = null
}

class Account : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var accountName: String = ""
    var accountType: String = ""
    var totalAmount: Int = 0
    var accountData: AccountData? = null
}

class AccountData : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var amount: Int = 0
    var comment: String = ""
    var category: Category? = null
}

class Category : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var type: String = ""
}

