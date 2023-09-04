package PhoneApp.objetos;

import java.util.Date;

import PhoneApp.interfaces.Call;

public class VoiceCall extends Callable{

    public VoiceCall(Contact caller, Contact recipient, double duration, Date date) {
        super(caller, recipient, duration, date);
    }

    @Override
    public Callable end() {

        if(callStart != 0 )this.setDuration( (System.currentTimeMillis() - callStart)/1000 );

        System.out.println(MSG_END.concat(" de voz."));
        return this;
    }

}
