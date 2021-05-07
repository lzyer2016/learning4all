package consistent.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash implements HashFunction {

  MessageDigest messageDigest;

  public MD5Hash() {
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

  @Override
  public long hash(String key) {
    messageDigest.reset();
    messageDigest.update(key.getBytes());
    byte[] digest = messageDigest.digest();
    long hash = 0;
    for (int i = 0; i < 4; i++) {
      hash <<= 8;
      hash |= ((int) digest[i]) & 0xFF;
    }
    return hash;
  }
}
