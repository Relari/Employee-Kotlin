package com.pe.relari.employeekotlin.example

class Person1 private constructor(builder: Builder) {

    val id: Int?
    val name: String?

    init {
        this.id = builder.id
        this.name = builder.name
    }

    class Builder {

        var id: Int? = null
            private set
        var name: String? = null
            private set

        fun id(id: Int) = apply { this.id = id }
        fun name(name: String) = apply { this.name = name }
        fun build() = Person1(this)
    }

    override fun toString(): String {
        return "Person1(id=$id, name=$name)"
    }
}

class Person2 {

    var id: Int = 0
    var name: String = ""

    fun id(id: Int): Person2 {
        this.id = id
        return this
    }

    fun name(name: String): Person2 {
        this.name = name
        return this
    }

    override fun toString(): String {
        return "Person2(id=$id, name=$name)"
    }
}

fun main() {

    val person = Person1.Builder()
            .id(1)
            .name("bacon")
            .build()

    println(person)

    val person1 = Person2()
            .id(1)
            .name("Renzo")

    println(person1)

    val person2 = Person2()
            .id(1)

    println(person2.id)
}