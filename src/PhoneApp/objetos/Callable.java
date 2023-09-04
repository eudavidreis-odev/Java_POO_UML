package PhoneApp.objetos;

import java.util.Date;

import PhoneApp.interfaces.Call;

public class Callable implements Call{
    private Contact caller;
    private Contact recipient;
    private double duration;
    private Date date;
    private boolean status;
    public long callStart;

    final String MSG_START = "Ligando para ";
    final String MSG_ACCEPT = "Aceitando chamada de ";
    final String MSG_END =  "Encerrando a chamada";

    public Callable(){
        this.caller = null;
        this.recipient = null;
        this.duration = 0.0;
        this.date = null;
        this.callStart = 0;
        this.status = false;
    }

    public Callable(Contact caller, Contact recipient, double duration, Date date) {
        this.caller = caller;
        this.recipient = recipient;
        this.duration = duration;
        this.date = date;
        this.status = false;
        this.callStart = 0;

    }

    @Override
    public void start() {
        callStart = System.currentTimeMillis();
        if(recipient.getName() == null) System.out.println(MSG_START.concat(recipient.getNumber()));
        else System.out.println(MSG_START.concat(recipient.getName()));
    }

    @Override
    public void accept() {
        callStart = System.currentTimeMillis();

        if(caller.name == null)System.out.println(MSG_ACCEPT.concat(caller.getNumber()));
        else System.out.println(MSG_ACCEPT.concat(caller.getName()));

        
    }

    @Override
    public Callable end() {
        if(callStart != 0 )duration = (System.currentTimeMillis() - callStart)/1000;
        System.out.println(MSG_END);
        return this;
    }

    public Contact getCaller() {
        return caller;
    }

    public void setCaller(Contact caller) {
        this.caller = caller;
    }

    public Contact getRecipient() {
        return recipient;
    }

    public void setRecipient(Contact recipient) {
        this.recipient = recipient;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    
}
