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

class ProductEntity(context: EventSourcedEntityContext) extends AbstractProductEntity {

  private val log: Logger = LoggerFactory.getLogger(classOf[ProductEntity]);

  private val entityId = context.entityId
  override def emptyState: Product = Product.defaultInstance

  override def createProduct(currentState: Product, createProductRequest: api.CreateProductRequest): EventSourcedEntity.Effect[Empty] =
    if(createProductRequest.name.isEmpty) {
      log.error("Product name is empty")
      effects.error("Product name can't be empty")
    } else {
      val product = ProductCreated(
        Some(Product(
          entityId,
          createProductRequest.name,
          createProductRequest.supplier)
        )
      )
      effects.emitEvent(product).thenReply(_ => Empty.defaultInstance)
    }

  override def productCreated(currentState: Product, productCreated: ProductCreated): Product =
    currentState

}
