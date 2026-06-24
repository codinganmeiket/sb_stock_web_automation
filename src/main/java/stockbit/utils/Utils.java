package stockbit.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Utils {

  /**
   * Retrieves the value of an environment variable specified by the provided key.
   * The key is automatically converted to uppercase to match the environment variable names.
   * If the environment variable is not found or the value is null, an empty string is returned.
   *
   * @param key the name of the environment variable to retrieve. The key is case-insensitive as it
   *            will be converted to uppercase internally.
   * @return the value of the specified environment variable, or an empty string if not found.
   */
  public static String getEnv(String key) {
    Dotenv env = Dotenv.configure().ignoreIfMissing().load();
    String value = env.get(key.toUpperCase());
    if (value == null) {
      return "";
    }
    return value;
  }

  /**
   * Suspends the execution of the current thread for the specified duration.
   * This method uses {@link Thread#sleep(long)} to introduce a deliberate delay.
   *
   * @param time the duration in milliseconds for which the current thread is to be suspended.
   *             Must be non-negative. Passing a negative value will not throw an exception but
   *             will result in no delay.
   * @throws RuntimeException if the current thread is interrupted while sleeping.
   */
  public static void staticWait(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
