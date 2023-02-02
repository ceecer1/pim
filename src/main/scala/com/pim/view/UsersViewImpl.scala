package com.pim.view

import com.pim.view.UserView
import com.pim.domain.{UserCreated, Users}
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class UsersViewImpl(context: ViewContext) extends AbstractUsersView {

  override def emptyState: UserView =
    UserView.defaultInstance

  override def processUserCreated(
    state: UserView, userCreated: UserCreated): UpdateEffect[UserView] = {
    if(state != emptyState) effects.ignore()
    else effects.updateState(convertToApi(userCreated.user.get))
  }

  private def convertToApi(user: Users): UserView =
    UserView(
      id = user.id,
      firstName = user.firstName,
      lastName = user.lastName,
      email = user.email,
      phone = user.phone
    )

}
