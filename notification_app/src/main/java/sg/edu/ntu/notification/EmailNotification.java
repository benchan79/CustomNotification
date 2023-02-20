package sg.edu.ntu.notification;

import java.util.concurrent.CompletableFuture;
import sg.edu.ntu.api.Connectable;

public class EmailNotification extends CustomNotification implements Connectable {
  private String index;

  public EmailNotification(String index, String to, String content) {
    super(to, content);
    this.index = index;
    this.init();
  }

  @Override
  public void send() {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      if (!CustomNotification.isOperating)
        throw new RuntimeException("Notification is currently not operating");
      System.out.println("Sending email " + this.index + " to " + this.to + " asynchronously");
      return "success";
    }).exceptionally((throwable) -> {
      System.out.println("Exception caught - " + throwable.getMessage());
      return "Error sending email " + this.index + " to " + this.to;
    });

    // future.thenAccept(result -> System.out.println("Status: " + result));
    future.thenAccept(result -> {}); // Remove msg for tidier output
  }

  @Override
  public void init() {
    // System.out.println("Initialize all properties needed to connect to email
    // server.");
  }

  @Override
  public boolean checkHasNetworkConnection() {
    System.out.println("Check whether has network connection");
    boolean isSuccess = true;
    if (isSuccess) {
      CustomNotification.isOperating = true;
    }
    return isSuccess;
  }
}
