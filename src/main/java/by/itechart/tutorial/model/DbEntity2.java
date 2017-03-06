package by.itechart.tutorial.model;

public class DbEntity2 {
    public DbEntity2(Integer duration, String message) {
        this.message = message;
        this.duration = duration;
    }

    private Integer duration;
    private String message;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
