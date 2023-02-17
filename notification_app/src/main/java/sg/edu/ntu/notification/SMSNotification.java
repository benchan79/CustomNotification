package sg.edu.ntu.notification;

import sg.edu.ntu.api.Connectable;

public class SMSNotification extends CustomNotification implements Connectable{

    // Constructor
    public SMSNotification(String to, String content){
        /*
         * The super keyword calls the parent's constructor
         */
        super(to, content);
        this.init();
    }

    // Method overriding
    @Override
    public void send(){
        // Add code      
    }

    @Override
    public void init() {
        System.out.println("Initialize all properties needed to connect to sms server.");
    }

    @Override
    public boolean checkHasNetworkConnection() {
        System.out.println("Check whether has network connection.");
        boolean isSuccess = true;
        if(isSuccess){
            CustomNotification.isOperating = true;
        }
        return isSuccess;
    }
}