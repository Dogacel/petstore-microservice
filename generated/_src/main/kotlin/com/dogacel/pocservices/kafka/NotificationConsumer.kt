package com.dogacel.pocservices.kafka

import com.dogacel.generated.model.Pet
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped

class NotificationSerializer : ObjectMapperSerializer<String?>()

@ApplicationScoped
class NotificationConsumer {

    @Incoming("notifications-in")
    suspend fun consume(notification: String) {
        println(notification)
    }
}
