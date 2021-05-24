package com.example.navigationdrawer

class ModelData(number : Int, type : Int) {

    private var Number : Int
    private var Type : Int
    private var Id : Int = 0

    init{
        Number = number
        Type = type
    }

    constructor(id : Int, number: Int, type: Int) : this(number, type){
        Id = id
    }

    fun getId() : Int{
        return Id
    }

    fun getNumber() : Int{
        return Number
    }

    fun getType() : Int{
        return Type
    }

    fun setId(id : Int){
        Id = id
    }

    fun setNumber(number : Int){
        Number = number
    }

    fun setType(type : Int){
        Type = type
    }

}