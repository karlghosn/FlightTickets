# FlightTickets
Flight Tickets App Retrofit and RxJava

Flight Tickets is an Android app highlighting the use of Retrofit and RxJava. 

In this app, we see the use of Retrofit and RxJava, as well as the implementation of the [ConcatMap](https://www.androidhive.info/RxJava/map-flatmap-switchmap-concatmap/) operator. We also see how to use a Single Observable with multiple Observers using replay() operator.

In this app, we use ConcatMap because:

* **ConcatMap()** maintains the order of items and waits for the current Observable to complete its job before emitting the next one.
* **ConcatMap()** is more suitable when you want to maintain the order of execution.
