package es.happ.server.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class SessionCuestionary.
 */
@Entity
@Table(name="session_questionary")
public class SessionQuestionaryEntity implements HappEntity{
	
	/** The session id. */
	@Id
	@GeneratedValue
	@Column(name="session_id", nullable=false, unique=true)
	private Long sessionId;
	
	/** The android id. */
	@Column(name="android_id",length=32, nullable=false)
	private String androidId;

	/** The date session. */
	@Column(name="date_session", nullable=false)
	private Timestamp dateSession;  
	
	/** The finished. */
	@Column(name="finished", nullable=false)
	private Boolean finished;
	
	/** The session answers. */
	@OneToMany(fetch = javax.persistence.FetchType.LAZY, mappedBy="sessionCuestionary")
	private Set<SessionAnswerEntity> sessionAnswers = new HashSet<SessionAnswerEntity>();
	

	/**
	 * Instantiates a new session cuestionary.
	 */
	public SessionQuestionaryEntity() {
		super();
	}

	/**
	 * Gets the session id.
	 *
	 * @return the session id
	 */
	public Long getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId the new session id
	 */
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Gets the android id.
	 *
	 * @return the android id
	 */
	public String getAndroidId() {
		return androidId;
	}

	/**
	 * Sets the android id.
	 *
	 * @param androidId the new android id
	 */
	public void setAndroidId(String androidId) {
		this.androidId = androidId;
	}

	/**
	 * Gets the date session.
	 *
	 * @return the date session
	 */
	public Timestamp getDateSession() {
		return dateSession;
	}

	/**
	 * Sets the date session.
	 *
	 * @param dateSession the new date session
	 */
	public void setDateSession(Timestamp dateSession) {
		this.dateSession = dateSession;
	}

	/**
	 * Gets the finished.
	 *
	 * @return the finished
	 */
	public Boolean getFinished() {
		return finished;
	}

	/**
	 * Sets the finished.
	 *
	 * @param finished the new finished
	 */
	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	/**
	 * Gets the session answers.
	 *
	 * @return the session answers
	 */
	public Set<SessionAnswerEntity> getSessionAnswers() {
		return sessionAnswers;
	}

	/**
	 * Sets the session answers.
	 *
	 * @param sessionAnswers the new session answers
	 */
	public void setSessionAnswers(Set<SessionAnswerEntity> sessionAnswers) {
		this.sessionAnswers = sessionAnswers;
	}

}
