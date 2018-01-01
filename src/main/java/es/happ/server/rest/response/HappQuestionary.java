package es.happ.server.rest.response;

import java.util.List;

import es.happ.server.model.QuestionaryModel;
import es.happ.server.model.ScheduledTaskQuestionaryModel;

public class HappQuestionary extends HappResponse {
	
	/** The questionary. */
	private List<QuestionaryModel> questionary;
	
	/** The first session questionary. */
	private ScheduledTaskQuestionaryModel firstSessionQuestionary;


	public List<QuestionaryModel> getQuestionary() {
		return questionary;
	}

	public void setQuestionary(List<QuestionaryModel> questionary) {
		this.questionary = questionary;
	}

	public ScheduledTaskQuestionaryModel getFirstSessionQuestionary() {
		return firstSessionQuestionary;
	}

	public void setFirstSessionQuestionary(ScheduledTaskQuestionaryModel firstSessionQuestionary) {
		this.firstSessionQuestionary = firstSessionQuestionary;
	} 

	

}
