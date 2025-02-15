

class Voltage240{
    public int provide240(){
        System.out.println("Providing high voltage... 240V");
        return 240;
    }
}

interface Voltage120{
    int provide120();
}

class Adapter implements Voltage120{
    private Voltage240 voltage240;

    public Adapter(Voltage240 voltage240) {
        this.voltage240 = voltage240;
    }

    public int provide120(){
        int hightVolt = voltage240.provide240();
        System.out.println("Converting 240V to 120V");
        int lowVolt = hightVolt/2;
        System.out.println("Providing low voltage of: " + lowVolt);
        return lowVolt;
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        Voltage240 voltage240 = new Voltage240();

        Adapter adapter = new Adapter(voltage240);

        int lowVolt = adapter.provide120();

    }
}
