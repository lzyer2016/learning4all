package consistent.hashing;

public interface HashFunction {

  long hash(String key);
}
