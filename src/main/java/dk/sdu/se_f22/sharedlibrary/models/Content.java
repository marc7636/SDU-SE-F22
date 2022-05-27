package dk.sdu.se_f22.sharedlibrary.models;

import org.jsoup.nodes.Document;

public class Content {
    private int pageId;
    private String html;
    private String title;
    private String timestamp;

    public Content(int pageId, String html, String title, String timestamp) {
        this.pageId = pageId;
        this.html = html;
        this.title = title;
        this.timestamp = timestamp;
    }

    public Content(int pageId, Document html, String timestamp) {
        this.pageId = pageId;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }

    public String getHtml() {
        return html;
    }

    public int getPageId() {
        return pageId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTitle() {
        return title;
    }
}
