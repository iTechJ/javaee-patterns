package by.itechart.tutorial.dto;

/**
 * Created by alexander.belyaev on 3/6/2017.
 */
public class Service2Result {

    public Service2Result(Integer duration, String message) {
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
