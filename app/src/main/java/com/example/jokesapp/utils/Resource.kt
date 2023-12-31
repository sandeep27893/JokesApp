package com.example.jokesapp.utils

data class Resource<out T>(val status : Status, val data : T?,val message :String?){
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object{
        fun<T> success(data: T) : Resource<T>{
            return Resource(Status.SUCCESS,data,null)
        }

        fun<T> error(data: T?=null, message: String) : Resource<T>{
            return Resource(Status.ERROR,data,null)
        }

        fun<T> loading(data: T?=null) : Resource<T>{
            return Resource(Status.LOADING,data,null)
        }

    }

}
