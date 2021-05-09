package message.queue;

public class Message {

  int size;
  byte[] buffer;

  public Message(int size, byte[] buffer) {
    this.size = size;
    this.buffer = buffer;
  }
}
