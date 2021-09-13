package entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "notes")
public class Note {
	@Id
	private int id;
	private String title;
	private String content;
	private Date created;
	
	
	
	
	
	public int getId() {
		return id;
	}
	
	public Note(int id, String title, String content, Date created) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.created = created;
	}

	public Note(String title2, String content2, Date date) {
		// TODO Auto-generated constructor stub
		this.title = title2;
		this.content = content2;
		this.created = date;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
