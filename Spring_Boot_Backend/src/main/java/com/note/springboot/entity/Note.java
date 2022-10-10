package com.note.springboot.entity;

import java.util.Date;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("Note")
public class Note {
	
	@Id
	@Property("title")
	private String title;
	
	@Property("description")
	private String description;
	
	@Property("last_updated_Date")
	private String lastUpdatedDate=new Date().toString().substring(0,10);
	
	public Note() {
		title="";
		description="";
	}

	public Note(String title, String description, String lastUpdatedDate) {
		this.title = title;
		this.description = description;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
