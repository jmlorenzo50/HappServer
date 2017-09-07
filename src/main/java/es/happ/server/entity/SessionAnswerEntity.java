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
 * The Class SessionAnswer.
 */
@Entity
@Table(name="session_answer")
public class SessionAnswerEntity  implements HappEntity{
	
	/** The session answer id. */
	@Id
	@GeneratedValue
	@Column(name="session_answer_id", nullable=false, unique=true)
	private Long sessionAnswerId;
	
	/** The session cuestionary. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sessionId", nullable = false)
	private SessionQuestionaryEntity sessionCuestionary;
	
	/** The questionary id. */
	@Column(name="questionary_id", nullable=false)
	private Long questionaryId;

	/** The question id. */
	@Column(name="question_id", nullable=false)
	private Long questionId;
	
	/** The answer id. */
	@Column(name="answer_id", nullable=false)
	private Long answerId;

	/**
	 * Instantiates a new session answer.
	 */
	public SessionAnswerEntity() {
		super();
	}

	/**
	 * Gets the session answer id.
	 *
	 * @return the session answer id
	 */
	public Long getSessionAnswerId() {
		return sessionAnswerId;
	}

	/**
	 * Sets the session answer id.
	 *
	 * @param sessionAnswerId the new session answer id
	 */
	public void setSessionAnswerId(Long sessionAnswerId) {
		this.sessionAnswerId = sessionAnswerId;
	}

	/**
	 * Gets the session cuestionary.
	 *
	 * @return the session cuestionary
	 */
	public SessionQuestionaryEntity getSessionCuestionary() {
		return sessionCuestionary;
	}

	/**
	 * Sets the session cuestionary.
	 *
	 * @param sessionCuestionary the new session cuestionary
	 */
	public void setSessionCuestionary(SessionQuestionaryEntity sessionCuestionary) {
		this.sessionCuestionary = sessionCuestionary;
	}

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
	
	

}
