package PhoneApp.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import PhoneApp.objetos.Callable;
import PhoneApp.objetos.VoiceMail;

/**
 * CallListener é o responsavel por receber e tratar as ligações,assim como iniciar uma 
 * ligação e etc.
 * @see Callable
 * @see VoiceMail
 */
public class CallListener {
  private List<Callable> activeCalls;
  private List<Callable> newCalls;
  private List<VoiceMail> voiceMails;

public CallListener() {
    activeCalls = new ArrayList<>();
    newCalls = new ArrayList<>();
    voiceMails = new ArrayList<>();
    
    voiceMails.add(new VoiceMail("(13)3647-4347","Responda essa mensagem com PROMOÇÃO, e veja as promoções diponíveis!"));
    voiceMails.add(new VoiceMail("(13)4578-4879","Oi, esse número é do Roberto?"));
    voiceMails.add(new VoiceMail("(13)3647-4347","Responda essa mensagem com OI, e ganhe 1 mês de internet grátis!"));


}

/**
 * Inicia uma chamada.
 * @param call Callable 
 * @return void
 */
public void startCall(Callable call) throws InterruptedException{

    if(call.getRecipient().getName()!= null)System.out.println("Ligando para "+call.getRecipient().getName());
    else System.out.println("Ligando para "+call.getRecipient().getNumber());
    
    TimeUnit.SECONDS.sleep((long) (Math.random()*3));
        
    activeCalls.add(call);
    call.start();
}

/**
 * Aceita uma chamada. 
 * @param call Callable
 * @return void
 */
public void acceptCall(Callable call) throws InterruptedException{
    if(call.getCaller().getName()!= null)System.out.println("Recebendo ligação de "+call.getCaller().getName());
    else System.out.println("Recebendo ligação de "+call.getCaller().getNumber());
    
    TimeUnit.SECONDS.sleep((long) (Math.random()*3));

    activeCalls.add(call);
    call.accept();
}
/**
 * Recusa uma chamada. 
 * @param call Callable
 * @return void
 */
public void declineCall(Callable call){
    call.setStatus(false);
    call.end();
}

/**
 * Termina uma chamada. 
 * @param call Callable
 * @return void
 */
public Callable endCall(Callable call){
    call.setStatus(true);
    activeCalls.remove(call);
    newCalls.remove(call);

    call.end();
    return call;
}

/**
 * Adiciona uma nova chamada, recebido ou feita. As chamadas são adicionadas a newCalls<Callable>,
 *  e assim podem ser atendidas, ou aguardar serem atendidas.  
 * @param call Callable
 * @return void
 */
public void addNewCall(Callable call){
    newCalls.add(call);
}

/**
 * Retorna as mensagens da caixa postal com base no número da mensagem. 
 * @param number String
 * @retunr List<VoiceMail> 
 */
public List<VoiceMail> getVoiceMailByNumber(String number){
    System.out.println("Procurando mensagens do número: "+number);
    return voiceMails.stream().filter(vm -> (vm.getNumber().equals(number))).toList();
}


public List<Callable> getActiveCalls() {
    return activeCalls;
}

public void setActiveCalls(List<Callable> activeCalls) {
    this.activeCalls = activeCalls;
}

public List<Callable> getNewCalls() {
    return newCalls;
}

public List<VoiceMail> getVoiceMails() {
    return voiceMails;
}

public void setVoiceMails(List<VoiceMail> voiceMails) {
    this.voiceMails = voiceMails;
}


 

}
