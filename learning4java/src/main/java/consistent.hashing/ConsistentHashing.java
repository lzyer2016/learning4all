package consistent.hashing;

import java.util.TreeMap;

public class ConsistentHashing {

  private TreeMap<Long, Node> hashRing = new TreeMap<>();

  private int virtualNodeCount;

  private static final int DEFAULT_REPLICA = 1;

  private HashFunction hashFunction;

  public ConsistentHashing() {
    this.virtualNodeCount = DEFAULT_REPLICA;
    this.hashFunction = new MD5Hash();
  }

  public ConsistentHashing(int vituralNodeCount, HashFunction hashFunction) {
    this.virtualNodeCount = vituralNodeCount;
    this.hashFunction = hashFunction;
  }

  public synchronized void add(Node node) {
    for (int i = 0; i < virtualNodeCount; i++) {
      addNode(node, i);
    }
  }

  private void addNode(Node node, int index) {
    long idx = getIdx(node, index);
    hashRing.put(idx, node);
  }

  public synchronized void remove(Node node) {
    for (int i = 0; i < virtualNodeCount; i++) {
      long idx = getIdx(node, i);
      hashRing.remove(idx);
    }
  }

  public Node getNode(String key) {
    long idx = hashFunction.hash(key);
    if (hashRing.ceilingEntry(idx) == null) {
      return hashRing.firstEntry().getValue();
    } else {
      return hashRing.ceilingEntry(idx).getValue();
    }
  }

  private long getIdx(Node node, int index) {
    return hashFunction.hash(node.getKey() + "#" + index);
  }
}
