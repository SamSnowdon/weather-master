Kafka is a type of message queue that maintains a partitioned storage (log). This is an ordered and immutable sequence,
known as records. Each record is assigned a number(id number), moving in sequential order, that helps identify each of the records. A producer can assign 
these ids when sending a record (message) to a broker. Each message that makes its way to the Kafka server has the partition for their topic selected, and 
the record is then placed at the end of the sequence.

A broker is an intermediary program that allows for the translation of messages from the formal messaging protocol from the publisher to the formal messaging 
protocol of the receiver. The message broker also helps decouple communication between certain devices that publish information. This decoupling allows the 
publishing service to not know anything about subscribers, it will only have to send messages to the broker which then manages and distributes these messages. 

Consumer groups are just groups of consumers that share the same group id. In a topic that as been consumed by consumers in the same group,each record only 
needs to be delivered to one of these consumers. This helps to ensure the parallel processing of records from a topic, and makes sure that the consumers will 
not be getting in the way of each other.

Ack is a setting used for client/producer configuration. It helps denote the number of brokers that need to receive a record before the write can be considered
successful. There are three main values, 0,1, and all. With a value of 0 the producer wont wait for the response from the broker and immediately considers the 
write successful from the moment the record is being sent out. With a value of 1 the producer will consider a write successful when the leader receives the 
record. When the value is set to all, the write is successful when all of the in sync replicas have received the record, which is achieved by the leader broker
sending back a response once all of the in sync replicas receive the record for themselves.
