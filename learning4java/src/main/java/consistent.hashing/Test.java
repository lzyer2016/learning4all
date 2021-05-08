package consistent.hashing;

import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

  public static void main(String[] args) {

    ConsistentHashing consistentHash = new ConsistentHashing(16, new MD5Hash());
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

    System.out.println("------数据均衡测试-------");
    Random random = new Random();
    TreeMap<String, AtomicInteger> res = new TreeMap<>();
    for (int i = 0; i < 100000; i++) {
      String s = "";
      for (int j = 0; j < 4; j++) {
        s += 'a' + random.nextInt(26);
      }
      Node myNode = consistentHash.getNode(s);
      res.putIfAbsent(myNode.getKey(), new AtomicInteger());
      res.get(myNode.getKey()).incrementAndGet();
    }
    System.out.println(res.toString());

  }
}
