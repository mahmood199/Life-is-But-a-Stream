package channel

/**
 *      [Channels] allow concurrent code to communicate with each other
 *      by sending and receiving messages between different coroutines.
 *      These are basically pipelines
 */
/**
 *      Channel() looks like a constructor… but Channel is an interface,
 *      not a class. So, Channel() is actually a top-level factory
 *      function that creates Channel objects of a particular type,
 *      based on its parameter.
 */

/**
 *      There is a third type of buffered channel [ConflatedChannel],
 *      based on the idea that it's fine if elements that
 *      were emitted are lost. This means that this type of
 *      channel has a buffer of only one element,
 *      and whenever a new element is sent,
 *      the previous one will be lost.
 *      This also means that the sender will never be suspended.
 */