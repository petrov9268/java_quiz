package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.OneToMany;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import java.util.List;

import hello.Comments;

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

	@OneToMany(mappedBy = "lessonId", cascade = CascadeType.ALL)
	//@JoinColumn(name = "lesson_id")
	private List<Comments> comments;
	
	public List<Comments> getLessonComments() {
		return comments;
	}
	
	public void setLessonComments(List<Comments> comments) {
		this.comments = comments;
	}

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
