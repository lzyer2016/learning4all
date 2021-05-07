package consistent.hashing;

public class Test {

  public static void main(String[] args) {

    ConsistentHashing consistentHash = new ConsistentHashing(2, new MD5Hash());
    consistentHash.add(new Node("node1", "127.0.0.1", "8080"));
    consistentHash.add(new Node("node2", "127.0.0.2", "8080"));
    consistentHash.add(new Node("node3", "127.0.0.3", "8080"));

    Node node = consistentHash.getNode("hello");
    System.out.println(node.getKey());

    Node node1 = consistentHash.getNode("world");
    System.out.println(node1.getKey());

    Node node2 = consistentHash.getNode("ok");
    System.out.println(node2.getKey());

    Node node4 = new Node("node4", "127.0.0.4", "8080");
    consistentHash.add(node4);
    System.out.println("---------------");
    node = consistentHash.getNode("hello");
    System.out.println(node.getKey());

    node1 = consistentHash.getNode("world");
    System.out.println(node1.getKey());

    node2 = consistentHash.getNode("ok");
    System.out.println(node2.getKey());


  }
}
