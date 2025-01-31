package org.example;

import java.net.URL;

public class TrainingsDaten {
	private String wort;
	private URL url;

	public TrainingsDaten(String wort, URL url) {
		this.wort = wort;
		this.url = url;
	}

	public String getWort() {
		return wort;
	}

	public URL getUrl() {
		return url;
	}

	public void setWort(String wort) {
		this.wort = wort;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
