package es.happ.server.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class QuestionaryEntity.
 */
@Entity
@Table(name="questionary")
public class QuestionaryEntity implements HappEntity{

	/** The questionary id. */
	@Id
	@GeneratedValue
	@Column(name="questionary_id", nullable=false, unique=true)
	private Long questionaryId;
	
	/** The description. */
	@Column(name="description", length=100, nullable=false)
	private String description;
	
	/** The statement. */
	@Column(name="statement", length=1000, nullable=false)
	private String statement;
	
	/** The questions. */
	@OneToMany(fetch = javax.persistence.FetchType.LAZY, mappedBy="questionary")
	private Set<QuestionEntity> questions = new HashSet<QuestionEntity>();
	
	/** The statement. */
	@Column(name="scheduled_pre")
	private Boolean scheduledPre;

	/** The statement. */
	@Column(name="scheduled_post")
	private Boolean scheduledPost;
	
	/**
	 * Gets the questionary id.
	 *
	 * @return the questionary id
	 */
	public Long getQuestionaryId() {
		return questionaryId;
	}

	/**
	 * Sets the questionary id.
	 *
	 * @param questionaryId the new questionary id
	 */
	public void setQuestionaryId(Long questionaryId) {
		this.questionaryId = questionaryId;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement the new statement
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
	public Set<QuestionEntity> getQuestions() {
		return questions;
	}

	/**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 */
	public void setQuestions(Set<QuestionEntity> questions) {
		this.questions = questions;
	}

	/**
	 * Gets the scheduled pre.
	 *
	 * @return the scheduled pre
	 */
	public Boolean getScheduledPre() {
		return scheduledPre;
	}

	/**
	 * Sets the scheduled pre.
	 *
	 * @param scheduledPre the new scheduled pre
	 */
	public void setScheduledPre(Boolean scheduledPre) {
		this.scheduledPre = scheduledPre;
	}

	/**
	 * Gets the scheduled post.
	 *
	 * @return the scheduled post
	 */
	public Boolean getScheduledPost() {
		return scheduledPost;
	}

	/**
	 * Sets the scheduled post.
	 *
	 * @param scheduledPost the new scheduled post
	 */
	public void setScheduledPost(Boolean scheduledPost) {
		this.scheduledPost = scheduledPost;
	}
	
	
}
