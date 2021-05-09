package message.queue;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.ArrayBlockingQueue;

public class ShutdownHookThread extends Thread {

  private ArrayBlockingQueue<Message> queue;

  private MappedFile mappedFile;

  public ShutdownHookThread(ArrayBlockingQueue<Message> queue, MappedFile mappedFile) {
    this.queue = queue;
    this.mappedFile = mappedFile;
  }

  @Override
  public void run() {
    System.out.println("invoke");
    ensureDirOk();
    try {
      if (queue.size() > 0) {
        int size = 0;
        for (Message message : queue) {
          size += 4 + message.size;
        }
        size += 4;
        System.out.println(size);
        RandomAccessFile randomAccessFile = new RandomAccessFile(mappedFile.getDir() + mappedFile.getName(), "rw");
        MappedByteBuffer out = randomAccessFile.getChannel().map(MapMode.READ_WRITE, 0, size);
        out.putInt(size);
        for (Message message : queue) {
          out.putInt(message.size);
          out.put(message.buffer);
        }
        randomAccessFile.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void ensureDirOk() {
    if (mappedFile.getDir() != null) {
      File file = new File(mappedFile.getDir());
      if (!file.exists()) {
        boolean result = file.mkdirs();
        System.out.println(mappedFile.getDir() + " mkdir " + (result ? "Ok" : "Failed"));
      }
    }
  }
}
