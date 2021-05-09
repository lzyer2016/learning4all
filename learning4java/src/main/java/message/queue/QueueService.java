package message.queue;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueService {

  private ArrayBlockingQueue<Message> queue = new ArrayBlockingQueue<>(512);

  private MappedFile mappedFile;

  public QueueService(MappedFile mappedFile) {
    this.mappedFile = mappedFile;
    // 反序列化
    init();
    // 序列化到磁盘
    Runtime.getRuntime().addShutdownHook(new ShutdownHookThread(queue, mappedFile));

  }

  private void init() {
    RandomAccessFile randomAccessFile = null;
    try {
      randomAccessFile = new RandomAccessFile(mappedFile.getDir() + mappedFile.getName(), "rw");
      FileChannel channel = randomAccessFile.getChannel();
      if (channel.size() > 0) {
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
        channel.read(byteBuffer);
        byteBuffer.flip();
        int size = byteBuffer.getInt();
        System.out.println(size);
        while (byteBuffer.remaining() > 0) {
          int len = byteBuffer.getInt();
          byte[] buffer = new byte[len];
          byteBuffer.get(buffer, 0, len);
          Message message = new Message(len, buffer);
          queue.add(message);
        }
        channel.close();
        Path path = Paths.get(mappedFile.getDir() + mappedFile.getName());
        Path pathHistory = Paths.get(mappedFile.getDir() + mappedFile.getName() + ".bak");
        Files.move(path, pathHistory);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void put(Message message) {
    queue.add(message);
  }

  public Message get() {
    return queue.poll();
  }

  public int size() {
    return queue.size();
  }
}
