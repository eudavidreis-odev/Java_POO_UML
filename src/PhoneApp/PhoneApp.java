package PhoneApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import PhoneApp.enuns.EnumContactsExampleData;
import PhoneApp.interfaces.Call;
import PhoneApp.listeners.CallListener;
import PhoneApp.objetos.Callable;
import PhoneApp.objetos.Contact;
import PhoneApp.objetos.VideoCall;
import PhoneApp.objetos.VoiceCall;

public class PhoneApp {
    private List<Callable> callHistory;
    private List<Contact> contacts;
    private CallListener callListener;


    public PhoneApp(){
        callHistory = new ArrayList<>();
        contacts = EnumContactsExampleData.getContatos();
        callListener = new CallListener();

    }

    public void voiceCall(String number){
        Contact caller = new Contact("Meu contato", "(12)99719-0932","Celular");
        Contact recipient = new Contact(null, number,getPhoneType(number));
        VoiceCall call = new VoiceCall(caller,recipient,0.0,new Date());
        callListener.addNewCall(call);
    }

    public void videoCall(String number){
        Contact caller = new Contact("Meu contato", "(12)99719-0932","Celular");
        Contact recipient = new Contact(null, number, getPhoneType(number));
        VideoCall call = new VideoCall(caller,recipient,0.0,new Date());
        callListener.addNewCall(call);
    }

    public void acceptCall() throws InterruptedException{
        if(getCallListener().getNewCalls().size() > 0) {
            CallListener listener = getCallListener();

            listener.acceptCall(getCallListener().getNewCalls().get(0)); 
            System.out.println("Chamada ativa...");
            TimeUnit.SECONDS.sleep((long) (Math.random()*10));

            
        }
    }

    public void startCall() throws InterruptedException{
        if(getCallListener().getNewCalls().size() > 0) {
            CallListener listener = getCallListener();

            listener.startCall(getCallListener().getNewCalls().get(0)); 
            System.out.println("Chamada ativa...");
            TimeUnit.SECONDS.sleep((long) (Math.random()*10));

            
        }
    }    

    public void endCall(){
        CallListener listener = getCallListener();
        Callable call = listener.getActiveCalls().get(0);
        call = listener.endCall(call);
        callHistory.add(call);
    }

    //ADICIONE UM METODO voiceCall(Contact recipient) e videoCall(Contact recipient).

    public void addContact(String name, String number, String type){
        contacts.add(new Contact(name, number, type));
    }

    public List<Callable> getLostCalls(){
        return callHistory.stream().filter(c -> !c.isStatus()).toList();
    }

    public List<Callable> getAcceptedCalls(){
        return callHistory.stream().filter(c -> c.isStatus()).toList();
    }

    public String getPhoneType(String number){
        if(number.length()== 14)return "Celular";
        else return "Fixo";
    } 

    public CallListener getCallListener() {
        return callListener;
    }

    public void setCallListener(CallListener callListener) {
        this.callListener = callListener;
    }

    public List<Callable> getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(List<Callable> callHistory) {
        this.callHistory = callHistory;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    

}
