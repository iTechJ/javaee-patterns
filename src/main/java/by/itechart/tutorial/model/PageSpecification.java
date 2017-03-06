package by.itechart.tutorial.model;

/* Just an example. You really shouldn't create your own template engine for JSP - there are quite a few on them available */
public class PageSpecification {
    public PageSpecification() {

    }

    public PageSpecification( String footer,  String header, String body) {
        this.footer = footer;
        this.header = header;
        this.body = body;
    }

    private String footer;
    private String header;
    private String body;

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
