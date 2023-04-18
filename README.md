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


## Send Channel
1. offer() adds the object to the channel if there is room in its buffer and returns true, otherwise it returns false
2. send() adds the object to the channel if there is room in its buffer and suspends otherwise until there is room

<br/>
send() suspends, it has the suspend keyword and must be called inside of a
coroutine. offer() does not suspend and can be called from normal functions, but
you need to deal with the case where it returns false. Here, “deal with” could simply
mean “ignore the return value and do not worry about the case where the offer was
not accepted”

You can proactively close a SendChannel by calling close(). A holder of a
SendChannel can see if it is closed via isClosedForSend(), while the holder of a
ReceiveChannel can see if it is closed via isClosedForReceive(). Iterating
consumers, such as consumeEach(), automatically check for closure and will handle
that accordingly — in the case of consumeEach(), it returns.

There are other “terminal operators” besides consumeEach() for getting data off of a
ReceiveChannel

1. offer() is a regular (non-suspend) function that puts an object into the
channel if there is room
2. poll() is a regular (non-suspend) function that takes an object out of the
channel if there is one, returning null otherwise
