package by.itechart.tutorial.dto;

public class Service1Params {
    public Service1Params(String info, String version) {
        this.info = info;
        this.version = version;
    }
    private String info;
    private String version;

    public String getInfo() {
        return info;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
