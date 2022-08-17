package com.example.livedatademo

import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) {
    var accNo : String = ""
    var owner : String = ""
    var balance: Double =0.0

    init {
        this.accNo = accNo
        this.owner = owner
        this.balance = balance
    }

    fun deposit(amount: Double) {
        balance += amount
    }

    fun withdraw(amount:Double){
        balance -= amount
    }

}