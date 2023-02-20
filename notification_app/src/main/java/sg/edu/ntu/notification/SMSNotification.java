package sg.edu.ntu.notification;

// import java.util.concurrent.CompletableFuture;

import sg.edu.ntu.api.Connectable;

public class SMSNotification extends CustomNotification implements Connectable {
  private String index;

  // Constructor
  public SMSNotification(String index, String to, String content) {
    /*
     * The super keyword calls the parent's constructor
     */
    super(to, content);
    this.index = index;
    this.init();
  }

  // Method overriding
  @Override
  public void send() {
    // CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    // if (!CustomNotification.isOperating)
    // throw new RuntimeException("Notification is currently not operating");
    // System.out.println("Sending SMS " + this.index + " to " + this.to + "
    // asynchronously");
    // return "success";
    // }).exceptionally((throwable) -> {
    // System.out.println("Exception caught - " + throwable.getMessage());
    // return "Error sending SMS " + this.index + " to " + this.to;
    // });

    // // future.thenAccept(result -> System.out.println("Status: " + result));
    // future.thenAccept(result -> {}); // Remove msg for tidier output
    System.out.println(
        Thread.currentThread().getName() + " :: Sending SMS " + this.index + " to " + this.to + " asynchronously");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException("Thread.sleep encountered error");
    }
  }

  @Override
  public void init() {
    System.out.println("Initialize all properties needed to connect to sms server.");
  }

  @Override
  public boolean checkHasNetworkConnection() {
    System.out.println("Check whether has network connection.");
    boolean isSuccess = true;
    if (isSuccess) {
      CustomNotification.isOperating = true;
    }
    return isSuccess;
  }
}