package by.itechart.tutorial;

/**
 * Created by alexander.belyaev on 3/3/2017.
 */
public class PageData {
    public PageData() {

    }

    public PageData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
