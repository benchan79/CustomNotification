package sg.edu.ntu.executorService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.concurrent.ThreadPoolExecutor;
import java.util.Queue;
import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.queue.NotificationQueue;

public class NotificationExecutor {
  private static ExecutorService executor;

  private NotificationExecutor() {
  }

  public static void init(int threadPool) {
    if (executor == null) {
      executor = Executors.newFixedThreadPool(threadPool);
    }
  }

  public static void start() throws InterruptedException {
    boolean hasQueue = true;

    Queue<CustomNotification> queue = NotificationQueue.getInstance();

    // int queueSize = queue.size();
    // MAIN thread
    // System.out.println(Thread.currentThread().getName()+" - Queue size: " + queue.size());
    System.out.println("\nInitializing Queue of size: " + queue.size());
    System.out.println("\nStarting Queue job...");
    System.out.println("===================================================================================\n");

    do {

      if (queue.size() <= 0) {
        // MAIN thread
        System.out.println(Thread.currentThread().getName() + " - Queue is empty. Breaking out of sleep and end this program.");
        hasQueue = false;
        break;
      }

      // ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executor;
      // int totalPoolSize = poolExecutor.getCorePoolSize();
      // int activePoolSize = poolExecutor.getActiveCount();
      // int availablePoolSize = totalPoolSize - activePoolSize;

      // MAIN thread
      // System.out.println(Thread.currentThread().getName()+" - Available pool size: "+availablePoolSize);

      // if (availablePoolSize > 0) {
      //   CustomNotification notification = queue.poll();
      //   executor.submit(() -> {
      //     notification.send();
      //   });
      // } else {
      //   Thread.sleep(500);
      // }

      CustomNotification notification = queue.poll();

      CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        notification.send();
        return "success";
      }, executor).exceptionally((throwable) -> {
        System.out.println("Exception caught - " + throwable.getMessage());
        return "Error";
      });
      future.thenAccept(result -> {
      });

    } while (hasQueue);

    executor.shutdown();

    while (!executor.isTerminated()) {
    }
    System.out.println("\n===================================================================================");
    System.out.println("Finished Queue job" + " :: Final Queue Size: " + queue.size());
  }
}