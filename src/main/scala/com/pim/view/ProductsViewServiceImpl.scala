package com.pim.view

import com.google.protobuf.empty.Empty
import com.pim.domain.{ProductCreated, UserCreated}
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ProductsViewServiceImpl(context: ViewContext) extends AbstractProductsViewServiceView {

  override def emptyState: ProductView =
    ProductView.defaultInstance

  override def processProductCreated(
    state: ProductView, productCreated: ProductCreated): UpdateEffect[ProductView] =
    if(state != emptyState) effects.ignore()
    else effects.updateState(convertToApi(productCreated.product.get))

  private def convertToApi(product: com.pim.domain.Product): ProductView =
    ProductView(id = product.id, name = product.name, supplier = product.supplier)
}
