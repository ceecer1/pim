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

class OrdersEntity(context: EventSourcedEntityContext) extends AbstractOrdersEntity {

  private val log: Logger = LoggerFactory.getLogger(classOf[UsersEntity]);

  override def emptyState: Order = Order.defaultInstance

  private val entityId = context.entityId

  override def create(currentState: Order, placeOrder: api.PlaceOrder): EventSourcedEntity.Effect[Empty] = {
    if (placeOrder.order.isEmpty) {
      log.error("Order is empty")
      effects.error("Order can't be empty")
    } else {
      val placedOrder = OrderPlaced(
        Some(Order(
          entityId,
          placeOrder.order.get.customerId,
          placeOrder.order.get.productId,
          placeOrder.order.get.quantity
        ))
      )
      effects.emitEvent(placedOrder).thenReply(_ => Empty.defaultInstance)
    }
  }

  override def orderPlaced(currentState: Order, orderPlaced: OrderPlaced): Order =
    currentState

}
