package com.example.livedatademo

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedatademo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var myAccountModel : AccountModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        // myAccountModel = AccountModel("A123", "John", 100.0)
        myAccountModel = ViewModelProvider(this).get(AccountModel::class.java)

        if(myAccountModel.owner == "") {
            myAccountModel.owner = "John"
            myAccountModel.accountNo = "A123"
            myAccountModel.accBalance.value = 100.0
        }
        display()

        myAccountModel.accBalance.observe(this, Observer{
            newBalance -> binding.tvBalance.text = newBalance.toString()
        })
        binding.btnDeposit.setOnClickListener(){
            val amount:Double = binding.tfAmount.text.toString().toDouble()
            myAccountModel.deposit(amount)
            display()

        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double = binding.tfAmount.text.toString().toDouble()
            myAccountModel.withdraw(amount)
            display()
        }
    }

    private fun display(){
        binding.tvName.text = myAccountModel.owner
        binding.tvAccNo.text = myAccountModel.accountNo
        binding.tvBalance.text = myAccountModel.accBalance.value.toString()
    }

}