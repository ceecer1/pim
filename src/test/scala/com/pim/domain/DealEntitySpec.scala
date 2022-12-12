package com.pim.domain

import com.example.deal.api
import com.google.protobuf.empty.Empty
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.testkit.EventSourcedResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class DealEntitySpec extends AnyWordSpec with Matchers {
  "The DealEntity" should {
    "have example test that can be removed" in {
      val testKit = DealEntityTestKit(new DealEntity(_))
      pending
      // use the testkit to execute a command:
      // val result: EventSourcedResult[R] = testKit.someOperation(SomeRequest("id"));
      // verify the emitted events
      // val actualEvent: ExpectedEvent = result.nextEventOfType[ExpectedEvent]
      // actualEvent shouldBe expectedEvent
      // verify the final state after applying the events
      // testKit.state() shouldBe expectedState
      // verify the reply
      // result.reply shouldBe expectedReply
      // verify the final state after the command
    }

    "correctly process commands of type CreateDeal" in {
      val testKit = DealEntityTestKit(new DealEntity(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createDeal(api.DealRequest(...))
    }

    "correctly process commands of type Pay" in {
      val testKit = DealEntityTestKit(new DealEntity(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.pay(api.PayDeal(...))
    }

    "correctly process commands of type Submit" in {
      val testKit = DealEntityTestKit(new DealEntity(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.submit(api.SubmitDeal(...))
    }

    "correctly process commands of type GetDeal" in {
      val testKit = DealEntityTestKit(new DealEntity(_))
      pending
      // val result: EventSourcedResult[api.DealStatus] = testKit.getDeal(api.GetDealRequest(...))
    }
  }
}
