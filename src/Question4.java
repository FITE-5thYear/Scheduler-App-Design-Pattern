
public class Question4 {
  
    public static void main(String[] args) {
       Client client = new Client();
  		
        client.SetReminderStrategy(new VoiceAlert());
   	
		client.SetReminderStrategy(new Notification());	
    		
    }
}


 interface ISetting 
{  
    String Reminder=null;
    String setting();
}
 
 //strategies

 //Strategy 1:Voice Alter
 class VoiceAlert implements ISetting 
 {
    @Override
    public String setting() 
    {
       return "Voice alert";
    }
 }
 
 //Strategy 2: Application Notification
 class Notification implements ISetting 
 {
    @Override
    public String setting() 
    {
       return "Notification";
    }
     
 }
 

 class Client 
 {
    private ISetting strategy;
 
    public String setting()
    {
        return strategy.setting();
    }
 	
     //Change the strategy
    public void SetReminderStrategy(ISetting strategy){
        this.strategy = strategy;
    }
 }
