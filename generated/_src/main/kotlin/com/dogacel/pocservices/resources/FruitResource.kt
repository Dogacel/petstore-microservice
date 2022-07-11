package com.dogacel.pocservices.resources

import com.dogacel.pocservices.models.Fruit
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path


@Path("/fruits")
class FruitResource {
    private val fruits = mutableSetOf<Fruit>()

    init {
        fruits.add(Fruit("Apple", "Red one"))
        fruits.add(Fruit("Plum", "Green plums"))

//        PetApi
    }

    @GET
    fun list(): Set<Fruit> {
        return fruits
    }

    @POST
    fun add(fruit: Fruit): Set<Fruit> {
        fruits.add(fruit)
        return fruits
    }

    @DELETE
    fun delete(name: String): Set<Fruit> {
        fruits.removeIf { it.name == name }
        return fruits
    }
}
