package phoneApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import phoneApp.enuns.EnumContactsExampleData;
import phoneApp.interfaces.Call;
import phoneApp.listeners.CallListener;
import phoneApp.objetos.Callable;
import phoneApp.objetos.Contact;
import phoneApp.objetos.VideoCall;
import phoneApp.objetos.VoiceCall;

/**
 * PhoneApp é a aplicação/serviço responsável por gerenciar as funções de "Telefone", neste caso, ligação de voz, vídeo, e 
 * serviço de caixa postal.
 */
public class PhoneApp {
    private List<Callable> callHistory;
    private List<Contact> contacts;
    private CallListener callListener;


    public PhoneApp(){
        callHistory = new ArrayList<>();
        contacts = EnumContactsExampleData.getContatos();
        callListener = new CallListener();

    }

    /**
     * Realiza uma chamada de voz, recebe o número a discar. 
     * @param number String 
     * @return void
     */
    public void voiceCall(String number){
        Contact caller = new Contact("Meu contato", "(12)99719-0932","Celular");
        Contact recipient = new Contact(null, number,getPhoneType(number));
        VoiceCall call = new VoiceCall(caller,recipient,0.0,new Date());
        callListener.addNewCall(call);
    }

    /**
     * Realiza uma chamada de vídeo, recebe o número a discar. 
     * @param number String 
     * @return void
     */
    public void videoCall(String number){
        Contact caller = new Contact("Meu contato", "(12)99719-0932","Celular");
        Contact recipient = new Contact(null, number, getPhoneType(number));
        VideoCall call = new VideoCall(caller,recipient,0.0,new Date());
        callListener.addNewCall(call);
    }

     /**
     * Realiza uma chamada de voz/vídeo usando o CallListener
     * @see Callable
     * @see CallListener 
     * @return void
     */
    public void acceptCall() throws InterruptedException{
        if(getCallListener().getNewCalls().size() > 0) {
            CallListener listener = getCallListener();

            listener.acceptCall(getCallListener().getNewCalls().get(0)); 
            System.out.println("Chamada ativa...");
            TimeUnit.SECONDS.sleep((long) (Math.random()*10));

            
        }
    }

     /**
     * Inicia uma chamada de voz/vídeo usando o CallListener
     * @see Callable
     * @see CallListener 
     * @return void
     */
    public void startCall() throws InterruptedException{
        if(getCallListener().getNewCalls().size() > 0) {
            CallListener listener = getCallListener();

            listener.startCall(getCallListener().getNewCalls().get(0)); 
            System.out.println("Chamada ativa...");
            TimeUnit.SECONDS.sleep((long) (Math.random()*10));

            
        }
    }    

    /**
     * Encerra uma chamada usando o CallListener. 
     * @return void
     */
    public void endCall(){
        CallListener listener = getCallListener();
        Callable call = listener.getActiveCalls().get(0);
        call = listener.endCall(call);
        callHistory.add(call);
    }
    //Você fuçãndo o código!!!
    //ADICIONE UM METODO voiceCall(Contact recipient) e videoCall(Contact recipient).

    /**
     * Adiciona um contato a lista de contatos.
     * @param name String O nome do contato. 
     * @param number String  O número do contato.
     * @param type String O tipe de telefone (fixo, celular). 
     * @return void
     **/
    public void addContact(String name, String number, String type){
        contacts.add(new Contact(name, number, type));
    }

    /**
     * Retorna as chamadas perdidas. 
     * @return List<Callable>
     */
    public List<Callable> getLostCalls(){
        return callHistory.stream().filter(c -> !c.isStatus()).toList();
    }

    /**
     * Retorna as chamadas atendidas. 
     * @return List<Callable>
     */
    public List<Callable> getAcceptedCalls(){
        return callHistory.stream().filter(c -> c.isStatus()).toList();
    }

    /**
     * Retorna o tipo de telefone com base no numero, retonar "fixo" ou "celular". 
     * @param number String 
     * @return String
     */
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
