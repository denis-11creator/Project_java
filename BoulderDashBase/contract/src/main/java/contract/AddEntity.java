package contract;

import java.util.ArrayList;

import model.*;

public class AddEntity {

	ArrayList<Entity> entities = new ArrayList<Entity>();

	/**
	 
	 * @author      Zangue Olivarex
	 * @since       2020-05-28
	 * @param e
	 */
	public void addEntity(Entity e)
	{
		entities.add(e);
	}


	public ArrayList<Entity> getEntity() {
		return entities;
	}

	public ArrayList<Entity> clear(){
		entities.clear();
		return entities;
	}
	
}


