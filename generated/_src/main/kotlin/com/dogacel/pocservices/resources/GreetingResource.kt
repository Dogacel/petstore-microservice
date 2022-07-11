package com.dogacel.pocservices.resources

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {

    @Inject
    @Channel("notifications-out")
    private lateinit var notificationEmitter: Emitter<String>

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        notificationEmitter.send("You said hello!")
        return "Hello from RESTEasy Reactive"
    }
}
