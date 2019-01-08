package hello;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "COMMENTS")
public class Comments {
    
	@Id
	@GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
	@Column(name = "LessonId", nullable = false)
    private Long lessonId;
	@Column(name = "Date", nullable = false)
    private String date;
	@Column(name = "Name", length = 40, nullable = false)
    private String name;
	@Column(name = "Comment", length = 280, nullable = false)
    private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
