package com.pim.action

import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class LoginServiceAction(creationContext: ActionCreationContext) extends AbstractLoginServiceAction {

  override def login(emailPassword: EmailPassword): Action.Effect[LoginResult] = {
    throw new RuntimeException("The command handler for `Login` is not implemented, yet")
  }
}

