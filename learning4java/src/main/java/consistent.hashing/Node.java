package consistent.hashing;

public class Node {

  String name;

  String ip;

  String port;

  public Node(String name, String ip, String port) {
    this.name = name;
    this.ip = ip;
    this.port = port;
  }

  public String getKey() {
    return name + "," + ip + "," + port;
  }
}
