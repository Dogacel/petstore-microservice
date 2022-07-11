package com.dogacel.pocservices.pet

import com.dogacel.generated.model.Category
import com.dogacel.generated.model.Pet
import javax.ws.rs.BadRequestException
import javax.ws.rs.GET
import javax.ws.rs.NotFoundException
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import kotlin.random.Random
import kotlin.random.Random.Default

@Path("/pet")
@Produces(MediaType.APPLICATION_JSON)
class PetController {
    private val mockPetStore: MutableSet<Pet> = mutableSetOf(
        Pet(
            "Pasha",
            arrayOf(),
            1,
            Category(1, "Tiger Boxer"),
            arrayOf(),
            Pet.Status.available
        )
    )

    @GET
    @Path("/")
    fun listPets(): List<Pet> {
        return mockPetStore.toList()
    }

    @GET
    @Path("/{id}")
    fun getPetById(@PathParam("id") id: Long): Pet {
        if (id < 0) throw BadRequestException("Id should be a non-negative number.")
        return mockPetStore.firstOrNull { it.id == id } ?: throw NotFoundException()
    }

    @POST
    @Path("/")
    fun addPet(pet: Pet): Pet {
        mockPetStore.add(pet)
        return pet
    }

    @PUT
    @Path("/{id}")
    fun updatePet(@PathParam("id") id: Long, pet: Pet): Pet {
        val remove = mockPetStore.removeIf { it.id == id }
        if (!remove) throw NotFoundException()
        mockPetStore.add(pet)
        return pet
    }
}
