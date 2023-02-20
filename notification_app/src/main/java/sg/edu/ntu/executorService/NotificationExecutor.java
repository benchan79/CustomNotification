package sg.edu.ntu.executorService;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sg.edu.ntu.notification.CustomNotification;
// import sg.edu.ntu.notification.EmailNotification;
import sg.edu.ntu.queue.NotificationQueue;

public class NotificationExecutor {

  private static ExecutorService executor;

  private NotificationExecutor(){}

  public static ExecutorService init(int poolSize) {
    if (executor == null) {
      executor = Executors.newFixedThreadPool(poolSize);
    }
    return executor;
  }

  public static void start() {
    Queue<CustomNotification> queue = NotificationQueue.getInstance();

    System.out.println("\nInitial Queue size: " + queue.size());
    System.out.println("\nStarting Queue job...");
    System.out.println("===================================================================================\n");
   
    int queueSize = queue.size();
    for (int i = 0; i < queueSize; i++) {
      // Runnable worker = new WorkerThread();
      // executor.submit(worker);
      CustomNotification notification = queue.poll();

      CompletableFuture.supplyAsync(() -> {
        notification.send();
        return "success";
      }, executor).exceptionally((throwable) -> {
        System.out.println("Exception caught - " + throwable.getMessage());
        return "Error";
      }).thenAccept(result -> {
      });
    }

    executor.shutdown();
    while (!executor.isTerminated()) {
    }
    System.out.println("\n===================================================================================");
    System.out.println("Finished Queue job" + " :: Final Queue Size: " + queue.size());
  }
}

// class WorkerThread implements Runnable {
//   @Override
//   public void run() {
//     Queue<CustomNotification> queue = NotificationQueue.getInstance();
//     CustomNotification toProcess = queue.poll();
//     toProcess.send();
//   }
// }