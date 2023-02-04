# Life-is-But-a-Stream
A project to demonstrate the use of kotlin flows, channels, and other components of Coroutines

## Brief about sending messages to channel 
The send() function in Channel is suspending. The reasoning behind this is that you may want to pause the code that is sending elements 
until there is someone actually listening for the data. 
This concept is often referred to as backpressure, and helps to prevent your
channels from being flooded with more elements than the receivers can actually process.


## Configuring back pressure
In order to configure this backpressure, you can define a buffer for your channel. The
coroutine sending data through the channel will be suspended when the elements in the
channel have reached the size of the buffer. Once elements are removed from the channel,
the sender will be resumed.

## Types of channels
![image](https://user-images.githubusercontent.com/58071934/216783715-d11da268-f244-4561-89c4-674a25cba6e7.png)

