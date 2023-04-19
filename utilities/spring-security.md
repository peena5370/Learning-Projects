# Password hasing methods with Spring Security

### Hashing Password with BCryptPasswordEncoder
```java
public class PasswordClass {
  private static final int strength = 12;

  /**
   * Encoding plain password as BCrypt hash value
   * @param   password  Plain text password
   * @return  Encoded BCrypt hash value
   */
  public static String encodePasswordAsBCrypt(String password) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

    return bCryptPasswordEncoder.encode(password); 
  }

  /**
   * Matching plain password with encrypted password by returning bool value
   * @param   rawPassword     Plain text password
   * @param   hashedPassword  Hashed BCrypt value
   * @return  Boolean
   */
  public static Boolean bCryptPasswordMatched(String rawPassword, String hashedPassword) {
    boolean bool = false;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

    if(bCryptPasswordEncoder.matches(rawPassword, hashedPassword)) {
      bool = true;
    }

    return bool;
  }
}

public class MainApplication {
  public static void main(String[] args) {
    String plainPassword = "password";
    String hashedPassword = PasswordClass.encodePasswordAsBCrypt(plainPassword);
    boolean bool = PasswordClass.bCryptPasswordMatched(plainPassword, hashedPassword);
    
    System.out.println("Plain password: " + plainPassword);
    System.out.println("Hashed password: " + hashedPassword);
    System.out.println("Boolean match: " + bool);
  }
}
```

### Hashing Password with PBKDF2PasswordEncoder
```java
public class PasswordClass {
  private static final String secretKey = "secretkey";
  private static final int iterations = 200000;
  private static final int saltLength = 16;
  private static final SecretKeyFactoryAlgorithm skfa = SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256;

  /**
   * Encode plain password as Pbkdf2 hash value
   * @param password  Plain text password
   * @return Encoded base64 Pbkdf2 hash value
   */
  public static String encodePasswordAsPbkdf2(String password) {
    Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(secretKey, saltLength, iterations, skf);
		pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);

    return pbkdf2PasswordEncoder.encode(password);
  }

  /**
   * Matching plain password with hashed value by returning bool value
   * @param   rawPassword     Plain text password
   * @param   hashedPassword  Hashed Pbkdf2 value
   * @return  Boolean
   */
  public static Boolean pbkdf2PasswordMatched(String rawPassword, String hashedPassword) {
    boolean bool = false;
    Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(secretKey, saltLength, iterations, skf);
    pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);

    if(pbkdf2PasswordEncoder.matches(rawPassword, hashedPassword)) {
      bool = true;
    }

    return bool;
  }
}

public class MainApplication {
  public static void main(String[] args) {
    String plainPassword = "password";
    String hashedPassword = PasswordClass.encodePasswordAsPbkdf2(plainPassword);
    boolean bool = PasswordClass.pbkdf2PasswordMatched(plainPassword, hashedPassword);

    System.out.println("Plain password: " + plainPassword);
    System.out.println("Hashed password: " + hashedPassword);
    System.out.println("Boolean match: " + bool);
  }
}
```