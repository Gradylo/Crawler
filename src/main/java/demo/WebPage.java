package demo;



public class WebPage {
	
	public enum PageType {
        song, playlist, playlists;
    }

    public enum Status {
        crawled, uncrawl;
    }

    private String url;
    
    private String title;
    
    private PageType type;
    
    private Status status;
    
    private String html;
    
	public WebPage(String url, PageType playlists) {
		 this.url=url;
		 this.type=playlists;
	}
	
	public WebPage(String url, PageType song, String html) {
		 this.url=url;
		 this.type=song;
		 this.html=html;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PageType getType() {
		return type;
	}

	public void setType(PageType type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
     
}
