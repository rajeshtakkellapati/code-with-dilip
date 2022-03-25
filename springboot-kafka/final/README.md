# Spring Boot Kafka

## Kafka Consumer

### Kafka Consumer Error Handling

### Default ErrorHandler

- The Kafka consumer comes with default error handling behavior.

- DefaultErrorHandler is the class which implements the default error handling logic for Kafka Consumer

- The error handler can recover (skip) a record that keeps failing. By default, after ten failures, the failed record is logged (at the ERROR level). 
