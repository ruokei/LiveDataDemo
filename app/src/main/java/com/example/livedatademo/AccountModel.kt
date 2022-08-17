package com.example.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String="", owner:String="", balance:Double=0.0): ViewModel(){
    private var accNo : String = ""
    var accountNo : String
        get() = accNo
        set(value){ accNo = value}

    var owner : String = ""

    private var balance = MutableLiveData<Double>()
    var accBalance : MutableLiveData<Double>
        get() = balance
        set(value){ balance = value}

    init {
        this.accNo = accNo
        this.owner = owner
        this.balance.value = balance
    }

    fun deposit(amount: Double) {
        balance.value = balance.value?.plus(amount)
    }

    fun withdraw(amount:Double){
        balance.value = balance.value?.minus(amount)
    }


}