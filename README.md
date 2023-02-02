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


# NOTES: [Make sure the following things are conidered]

 - Use the latest Kalix SDK version
 - Use the latest Kalix-proxy container image inside docker-compose
 - Send the name of services in email where you are composing complex SQL like Kalix View queries 
to enable advanced view joins feature
 - You do not need to enable this advanced view flag for S2S eventing producer and consumers, unless you are composing 
them in views
 - Use loggers inside the handler methods for debugging



