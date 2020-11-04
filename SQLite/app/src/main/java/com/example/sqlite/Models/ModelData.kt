package com.example.sqlite.Models

class ModelData(name : String, email : String) {

    private var Name : String
    private var Email : String
    private var Id : Int = -1

    init{
        Name = name
        Email = email
    }

    constructor(id : Int, name : String, email : String) : this(name, email){
        Id = id
    }

    fun getName() : String{
        return Name
    }

    fun getEmail() : String{
        return Email
    }

    fun getId() : Int{
        return Id
    }

}