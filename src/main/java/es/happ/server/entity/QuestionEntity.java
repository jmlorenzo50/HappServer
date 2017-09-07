package es.happ.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class QuestionEntity {

	@Id
	@GeneratedValue
	@Column(name="question_id", nullable=false, unique=true)
	private Long questionId;
	
}
