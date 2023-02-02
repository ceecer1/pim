# Kalix views examples in protobuf and scala

While this example application is based on Scala, the main meat of the example is the protobuf declarations,
the user defined small lines of code inside the Kalix generated scala methods are easy to understand and 
follow the same semantics as java, quite readable.

## Simple views

src/main/protobuf/com/pim/view/users_view.proto

This example provides grpc api to list users 

## Advanced View with Service to Service eventing

The producer application sends product events to this consumer application.

If you look at the protobuf specs at src/main/protobuf/com/pim/view/products_events_view.proto, it should 
be easy to understand

This example provides view joins within the entities in the same service (User and Order) and third entity from another 
producer microservice

This example provides grpc api to list customer orders.





