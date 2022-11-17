package com.example.databindingtest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databindingtest.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var NAME: String
    private val message :String = "message"
    val mobilePattern = "[6-9]{1}[0-9]{9}"
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

// initilize the pattern variables



//   Passing the conditions Using Data binding

        dataBinding.Submit.setOnClickListener {

            mydetails()
            namevalidation()
            mobileValidation()
            emailvalidation()

        }

    }
    private fun namevalidation(){
        if (dataBinding.first.text.toString().isEmpty()){
            dataBinding.first.setError("Enter your first Name")
            dataBinding.first.requestFocus()}


        if (dataBinding.Last.text.toString().isEmpty()) {
            dataBinding.Last.setError("Enter your last Name")
            dataBinding.Last.requestFocus()

        }
    }

    private fun mobileValidation(){

        if (dataBinding.Mobile.text.toString().isEmpty()) {
            dataBinding.Mobile.setError("Enter your mobile number")
            dataBinding.Mobile.requestFocus()}

        if (dataBinding.Mobile.text.toString().length<10) {
            dataBinding.Mobile.setError("Enter 10 digit valid mobile number")
            dataBinding.Mobile.requestFocus()}

        else if (!dataBinding.Mobile.text.toString().matches(mobilePattern .toRegex())) {
            dataBinding.Mobile.setError("number must be start with 6, 7, 8 ,9")
            dataBinding.Mobile.requestFocus()

        }
    }
    private fun emailvalidation(): String? {
        if (dataBinding.Email.text.toString().isEmpty()) {
            dataBinding.Email.setError("Enter Email Id")
            dataBinding.Email.requestFocus()


        } else if (!dataBinding.Email.text.toString().contains("@gmail.com",true)){
            dataBinding.Email.setError("Invalid email")
        }
        if (!dataBinding.Email.text.toString().matches(emailPattern.toRegex())) {
            dataBinding.Email.setError("Enter valid  Email Id")
            dataBinding.Email.requestFocus()

        }
        return null
    }
    private fun mydetails(){
        if ( dataBinding.first.text.toString().isNotEmpty()&& dataBinding.Last.text.toString().isNotEmpty()&&
            !(dataBinding.Mobile.text.toString().length<10)&& dataBinding.Mobile.text.toString().matches(mobilePattern .toRegex())
            && dataBinding.Email.text.toString().matches(emailPattern.toRegex())){


            dataBinding.Display.text = "Name:" + dataBinding.first.text.toString()+ " " + dataBinding.Middle.text.toString()+ " " +
                    dataBinding.Last.text.toString()+ "\n" +
                    "Mobile no:" + dataBinding.Mobile.text.toString() + "\n" +
                    "Email:" + dataBinding.Email.text.toString()

        }
    }

}









