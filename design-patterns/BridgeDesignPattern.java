
interface Device{
    void turnOn();
    void turnOff();
    void IncreaseVol(int vol);
}

class SonyTv implements Device{

    @Override
    public void IncreaseVol(int vol) {
        System.out.println("Increasing volume of sony TV to: " + vol);
        
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off sony TV");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON sony TV");        
    }
    
}

class LGTv implements Device{

    @Override
    public void IncreaseVol(int vol) {
        System.out.println("Increasing volume of LG TV to: " + vol);
        
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off LG TV");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning ON LG TV");        
    }
    
}

class RemoteControl{
    protected Device device;
    protected int vol = 0;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void on(){
        System.out.println("Pressed ON button: ");
        device.turnOn();
    }

    public void off(){
        System.out.println("Pressed OFF button");
        device.turnOff();
    }

    public void increaseVol(){
        System.out.println("Pressed increase volume button");
        this.vol  += 1;
        device.IncreaseVol(this.vol);
    }
}


public class BridgeDesignPattern {
    public static void main(String[] args) {
        Device sonyTv = new SonyTv();

        RemoteControl sonyRemote = new RemoteControl(sonyTv);

        Device lgTv = new LGTv();
        RemoteControl LGremote = new RemoteControl(lgTv);

        sonyRemote.on();
        sonyRemote.increaseVol();
        sonyRemote.off();


        LGremote.on();
        LGremote.increaseVol();
        LGremote.off();


    }
}
