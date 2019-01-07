package hello;

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
	@Column(name = "Name", length = 64, nullable = true)
    private String name;
	@Column(name = "Comment", length = 280, nullable = true)
    private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
