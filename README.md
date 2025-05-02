Write a simple Load Balancer. This is a pair programming session to simulate real work scenarios:



Register instances

It should be possible to register an instance, identified by an address

Each address should be unique, it should not be possible to register the same address more than once

Load Balancer should accept NOT more than 10 addresses

Create an AddressInstance class to represent an instance with a unique address.

Implement a LoadBalancer class with a method to register instances, ensuring uniqueness and a maximum of 10 instances.

Develop an algorithm that, when invoking the Load Balancer 's get() method multiple times, should return one backend-instance choosing between the registered ones randomly.

Develop an algorithm that, when invoking multiple times the Load Balancer on its get() method, should  return one backend-instance choosing between the registered one sequentially (round-robin)

Unit tests are required. Tests checks the uniqueness of addresses.

A final test ensures the load balancer doesn't accept more than ten addresses.
