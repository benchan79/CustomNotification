package sg.edu.ntu;

import java.util.Queue;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

import sg.edu.ntu.executorService.NotificationExecutor;
import sg.edu.ntu.notification.CustomNotification;
import sg.edu.ntu.notification.EmailNotification;
// import sg.edu.ntu.notification.SMSNotification;
import sg.edu.ntu.queue.NotificationQueue;

public class App {
  public static void main(String[] args) {
    // Instantiate LinkedList queue
    Queue<CustomNotification> queue = NotificationQueue.getInstance();

    // Insert objects into the queue
    int queueSize = 50;
    for (int i = 0; i < queueSize; i++) {
      CustomNotification email = new EmailNotification("index:" + i, "Daniel@mail.com", "HELLO");
      queue.add(email);
    }

    // Declare a thread pool executor
    int poolSize = 5;
    NotificationExecutor.init(poolSize);

    NotificationExecutor.start();
  }
}

