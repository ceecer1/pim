package com.pim.domain

import com.google.protobuf.empty.Empty
import com.pim.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext
import org.slf4j.{Logger, LoggerFactory}

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class UsersEntity(context: EventSourcedEntityContext) extends AbstractUsersEntity {

  private val log: Logger = LoggerFactory.getLogger(classOf[UsersEntity]);

  private val entityId = context.entityId

  override def emptyState: Users = Users.defaultInstance

  override def createUser(currentState: Users,
                          createUserRequest: api.CreateUserRequest): EventSourcedEntity.Effect[Empty] = {
    if(createUserRequest.email.isEmpty) {
      log.error("Email is empty")
      effects.error("Email can't be empty")
    } else {
      val user = UserCreated(
        Some(Users(
          entityId,
          createUserRequest.firstName,
          createUserRequest.lastName,
          createUserRequest.email,
          createUserRequest.password,
          createUserRequest.phone)
        )
      )
      effects.emitEvent(user).thenReply(_ => Empty.defaultInstance)
    }
  }

  override def userCreated(currentState: Users, userCreated: UserCreated): Users = {
    log.info(s"Current user details for entity id: $entityId is: $currentState")
    log.info(s"User created details for entity id: $entityId is: $userCreated")
    currentState
  }
}
