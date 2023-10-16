package com.akhil.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="DATA_STORE")
public class CrawlData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="URL")
	private String url; 
	
	@Column(name="Text_data", length = 1000000)
	private String urlData ;

	public CrawlData(String url, String urlData) {
		super();
		this.url = url;
		this.urlData = urlData;
	}

	public CrawlData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlData() {
		return urlData;
	}

	public void setUrlData(String urlData) {
		this.urlData = urlData;
	}
	
}
