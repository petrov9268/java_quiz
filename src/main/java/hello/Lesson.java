package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "COURSE")
public class Lesson {
    
	@Id
	@GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
	@Column(name = "Title", length = 64, nullable = false)
    private String title;
	@Column(name = "LessonText", length = 1024, nullable = false)
    private String lessonText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLessonText() {
		return lessonText;
	}

	public void setLessonText(String lessonText) {
		this.lessonText = lessonText;
	}
}
