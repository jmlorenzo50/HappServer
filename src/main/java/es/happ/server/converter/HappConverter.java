package es.happ.server.converter;

import es.happ.server.entity.HappEntity;
import es.happ.server.model.HappModel;

/**
 * The Interface HappConverter.
 */
public interface HappConverter {
	
	/**
	 * To entity.
	 *
	 * @param model the model
	 * @return the happ entity
	 */
	public HappEntity toEntity(HappModel model);
	
	/**
	 * To model.
	 *
	 * @param entity the entity
	 * @return the happ model
	 */
	public HappModel toModel(HappEntity entity);

}
