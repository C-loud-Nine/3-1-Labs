//Roll -- 2007055
//Name -- Abdullah Al Shafi
//In this code proxy design pattern is followed . Here RemoteProxy class acts as a proxy for the TV interface



interface TV {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}

class GeneralTV extends SmartTV implements TV {
    private boolean powerOn = false;
    private int volume = 0;
    private int channel = 0;

    public boolean isEnabled() {
        return powerOn;
    }

    public void enable() {
        powerOn = true;
    }

    public void disable() {
        powerOn = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume set to: " + this.volume);
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Channel set to: " + this.channel);
    }
}

class SmartTV implements TV {
    private boolean powerOn = false;
    private int volume = 0;
    private int channel = 0;

    public boolean isEnabled() {
        return powerOn;
    }

    public void enable() {
        powerOn = true;
    }

    public void disable() {
        powerOn = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Volume set to: " + this.volume);
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Channel set to: " + this.channel);
    }

    public void openYouTube() {
        System.out.println("YouTube opened.");
    }
}

interface Remote {
    void togglePower();
    void volumeUp();
    void volumeDown();
    void channelUp();
    void channelDown();
}

class RemoteProxy implements Remote {
    private final TV tv;

    public RemoteProxy(TV tv) {
        this.tv = tv;
    }

    public void togglePower() {
        if (tv.isEnabled()) {
            tv.disable();
            System.out.println("TV turned off.");
        } else {
            tv.enable();
            System.out.println("TV turned on.");
        }
    }

    public void volumeUp() {
        tv.setVolume(tv.getVolume() + 1);
    }

    public void volumeDown() {
        tv.setVolume(tv.getVolume() - 1);
    }

    public void channelUp() {
        tv.setChannel(tv.getChannel() + 1);
    }

    public void channelDown() {
        tv.setChannel(tv.getChannel() - 1);
    }
}

class SmartRemote extends RemoteProxy {
    private final SmartTV smartTV;

    public SmartRemote(SmartTV smartTV) {
        super(smartTV);
        this.smartTV = smartTV;
    }

    public void openYouTube() {
        smartTV.openYouTube();
    }
}

public class Main {
    public static void main(String[] args) {
        GeneralTV generalTV = new GeneralTV();
        SmartTV smartTV = new SmartTV();

        Remote generalRemote = new RemoteProxy(generalTV);
        SmartRemote smartRemote = new SmartRemote(smartTV);

        // Operating generalTV by remote
        generalRemote.togglePower();
        generalRemote.channelUp();
        generalRemote.channelDown();
        generalRemote.volumeUp();
        generalRemote.volumeDown();
        generalRemote.togglePower();

        System.out.println();

        // Operating SmartTV by remote
        smartRemote.togglePower();
        smartRemote.channelUp();
        smartRemote.channelDown();
        smartRemote.volumeUp();
        smartRemote.volumeDown();
        smartRemote.togglePower();

        System.out.println();

        // Operating generalTV by smartRemote (which is actually a proxy)
        generalRemote = new SmartRemote(generalTV);
        generalRemote.togglePower();
        generalRemote.channelUp();
        generalRemote.channelDown();
        generalRemote.volumeUp();
        generalRemote.volumeDown();
        ((SmartRemote) generalRemote).openYouTube();
        generalRemote.togglePower();

        System.out.println();

        // Operating SmartTV by smartRemote
        smartRemote = new SmartRemote(smartTV);
        smartRemote.togglePower();
        smartRemote.channelUp();
        smartRemote.channelDown();
        smartRemote.volumeUp();
        smartRemote.volumeDown();
        smartRemote.openYouTube();
        smartRemote.togglePower();
    }
}
