package demo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import demo.WebPage.PageType;

public class CrawlerThread {
	private boolean fetchHtml(WebPage webPage) throws IOException {
	    Connection.Response response = Jsoup.connect(webPage.getUrl()).timeout(3000).execute();
	    webPage.setHtml(response.body());
	    return response.statusCode() / 100 == 2 ? true : false;
	}
	
	private List<WebPage> parsePlaylist(WebPage webPage) {
	    Elements songs = Jsoup.parse(webPage.getHtml()).select(".f-hide");
//	    System.out.println(webPage.getHtml());
	    List<WebPage> list=new ArrayList<WebPage>();
	    for (Element e : songs) {
			list.add(new WebPage(webPage.getUrl() + e.attr("href"), PageType.playlist, e.html()));
		}
	    return list;
	}
	
	public static void main(String[] args) throws Exception {
		 WebPage playlists = new WebPage("http://music.163.com/#/discover/playlist", PageType.playlists);
		    CrawlerThread crawlerThread = new CrawlerThread();
		    crawlerThread.fetchHtml(playlists);
		    System.out.println(crawlerThread.parsePlaylist(playlists));
	}
}
