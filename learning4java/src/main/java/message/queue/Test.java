package message.queue;

import java.io.IOException;

public class Test {

  public static void main(String[] args) {
    String dir = "/Users/lzyer2016/logs/";
    String name = "data.txt";
    MappedFile mappedFile = new MappedFile(dir, name);
    QueueService queueService = new QueueService(mappedFile);
    String buffer = "hello world";
    Message message = new Message(buffer.getBytes().length, buffer.getBytes());
    queueService.put(message);
    String buffer2 = "ok";
    Message message2 = new Message(buffer2.getBytes().length, buffer2.getBytes());
    queueService.put(message2);

    while (queueService.size() > 0) {
      Message temp = queueService.get();
      System.out.println(new String(temp.buffer));
    }
  }
}
