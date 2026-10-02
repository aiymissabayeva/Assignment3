public class BasicRemote extends Remote {

    private final int volume = 30;

    public BasicRemote(String id, Device device) {
        super(id, device);
    }

    @Override
    public String execute() {
        return device.applySettings(true, volume);
    }
}