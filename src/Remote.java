public abstract class Remote {
    private final String id;
    protected Device device;

    public Remote(String id, Device device) {
        this.id = id;
        this.device = device;
    }

    public String getId() {
        return id;
    }

    public void setImplementation(Device device) {
        this.device = device;
    }

    public abstract String execute();
}