package by.itechart.tutorial.dto;

/**
 * Created by alexander.belyaev on 3/6/2017.
 */
public class Service2Params {
    public Service2Params(String start, String end) {
        this.start = start;
        this.end = end;
    }
    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
