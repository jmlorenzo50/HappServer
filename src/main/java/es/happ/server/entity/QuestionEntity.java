package es.happ.server.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class QuestionEntity.
 */
@Entity
@Table(name="question")
public class QuestionEntity implements HappEntity {

	/** The question id. */
	@Id
	@GeneratedValue
	@Column(name="question_id", nullable=false, unique=true)
	private Long questionId;
	
	
	/** The description. */
	@Column(name="description", length=100, nullable=false)
	private String description;
	
	/** The statement. */
	@Column(name="statement", length=1000, nullable=false)
	private String statement;
	
	/** The Questionary. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="questionaryId", nullable = false)
	private QuestionaryEntity questionary;

	/** The answers. */
	@OneToMany(fetch = javax.persistence.FetchType.LAZY, mappedBy="question")
	private Set<AnswerEntity> answers = new HashSet<AnswerEntity>();

	
	/**
	 * Instantiates a new question entity.
	 */
	public QuestionEntity() {
		super();
	}

	/**
	 * Gets the question id.
	 *
	 * @return the question id
	 */
	public Long getQuestionId() {
		return questionId;
	}

	/**
	 * Sets the question id.
	 *
	 * @param questionId the new question id
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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
	 * Gets the questionary.
	 *
	 * @return the questionary
	 */
	public QuestionaryEntity getQuestionary() {
		return questionary;
	}

	/**
	 * Sets the questionary.
	 *
	 * @param questionary the new questionary
	 */
	public void setQuestionary(QuestionaryEntity questionary) {
		this.questionary = questionary;
	}

	/**
	 * Gets the answers.
	 *
	 * @return the answers
	 */
	public Set<AnswerEntity> getAnswers() {
		return answers;
	}

	/**
	 * Sets the answers.
	 *
	 * @param answers the new answers
	 */
	public void setAnswers(Set<AnswerEntity> answers) {
		this.answers = answers;
	}
	

	
}
