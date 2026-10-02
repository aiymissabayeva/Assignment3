public class QuietRemote extends Remote {

    private final int volume = 5;

    public QuietRemote(String id, Device device) {
        super(id, device);
    }

    @Override
    public String execute() {
        return device.applySettings(true, volume);
    }
}