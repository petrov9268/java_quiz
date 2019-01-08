package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.OneToMany;
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
	@Column(name = "Question", length = 280, nullable = true)
    private String question;
	@Column(name = "Answer", nullable = true)
    private Integer answer;
	@Column(name = "Option_1", length = 40, nullable = true)
    private String option1;
	@Column(name = "Option_2", length = 40, nullable = true)
    private String option2;
	@Column(name = "Option_3", length = 40, nullable = true)
    private String option3;

	@OneToMany(mappedBy = "lessonId", cascade = CascadeType.ALL)
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
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	
	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}	
	
	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}
}
