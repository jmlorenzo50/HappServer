package es.happ.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class AnswerEntity.
 */
@Entity
@Table(name="answer")
public class AnswerEntity implements HappEntity{
	
	
	/** The answer id. */
	@Id
	@GeneratedValue
	@Column(name="answer_id", nullable=false, unique=true)
	private Long answerId;
	
	/** The text. */
	@Column(name="value", nullable=false)
	private Integer value;
	
	/** The text. */
	@Column(name="text", length=500, nullable=false)
	private String text;
	
	/** The Question. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="questionId", nullable = false)
	private QuestionEntity question;

	/**
	 * Instantiates a new answer entity.
	 */
	public AnswerEntity() {
		super();
	}

	/**
	 * Gets the answer id.
	 *
	 * @return the answer id
	 */
	public Long getAnswerId() {
		return answerId;
	}

	/**
	 * Sets the answer id.
	 *
	 * @param answerId the new answer id
	 */
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public QuestionEntity getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

}
