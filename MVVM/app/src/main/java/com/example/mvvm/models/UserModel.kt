package com.example.mvvm.models

class UserModel(private var id : Int, private val Login : String, private val Password : String) {

    private var Id : Int = 0
    private var login : String = ""
    private var password : String = ""

    init{
        Id = 0
        login = Login
        password = Password
    }

    fun setId(id : Int){
        Id = id
    }

    fun setLogin(user : String){
        login = user
    }

    fun setPassword(passwd : String){
        password = passwd
    }

    fun getId() : Int{
        return Id
    }

    fun getLogin() : String{
        return login
    }

    fun getPassword() : String{
        return password
    }
}