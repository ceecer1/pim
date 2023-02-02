package com.pim.view

import com.google.protobuf.empty.Empty
import com.pim.domain.{Order, OrderPlaced, Product, ProductCreated, UserCreated, Users}
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class IncomingProductStreamViewImpl(context: ViewContext) extends AbstractIncomingProductStreamView {

  object AllProductsViewTable extends AbstractAllProductsViewTable {

    override def emptyState: Product =
      Product.defaultInstance

    override def updateProducts(
        state: Product,
        productCreated: ProductCreated): UpdateEffect[Product] =
      if(state != emptyState) effects.ignore()
      else effects.updateState(productCreated.getProduct)

  }

  object OrdersViewTable extends AbstractOrdersViewTable {

    override def emptyState: Order =
      Order.defaultInstance

    override def updateOrders(
        state: Order,
        orderPlaced: OrderPlaced): UpdateEffect[Order] =
      if(state != emptyState) effects.ignore()
      else effects.updateState(orderPlaced.getOrder)

  }

  object CustomersViewTable extends AbstractCustomersViewTable {

    override def emptyState: CustomerView =
      CustomerView.defaultInstance

    override def updateCustomers(
        state: CustomerView,
        userCreated: UserCreated): UpdateEffect[CustomerView] =
      if(state != emptyState) effects.ignore()
      else effects.updateState(toCustomerView(userCreated.getUser))

    private def toCustomerView(user: Users): CustomerView =
      CustomerView(id = user.id,
        firstName = user.firstName,
        lastName = user.lastName,
        email = user.email,
        phone = user.phone)

  }

}
