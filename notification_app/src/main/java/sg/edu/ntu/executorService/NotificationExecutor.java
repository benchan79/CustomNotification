package sg.edu.ntu.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationExecutor {

  private static ExecutorService instance;

  private NotificationExecutor(){}

  public static ExecutorService getInstance(int poolSize) {
    instance = Executors.newFixedThreadPool(poolSize);
    return instance;
  }

}
