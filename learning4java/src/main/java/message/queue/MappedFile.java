package message.queue;

public class MappedFile {

  private String dir;

  private String name;

  public MappedFile(String dir, String name){
    this.dir = dir;
    this.name = name;
  }

  public String getDir() {
    return dir;
  }

  public String getName() {
    return name;
  }
}
