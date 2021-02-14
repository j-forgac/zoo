package cz.forgac.zoo.managers;

import cz.forgac.zoo.entities.animalEntity;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;

@ApplicationScoped
public class MujManager {
	private HashMap<Integer, animalEntity> animals = new HashMap<>();

	public HashMap<Integer, animalEntity> getAll() {
		return animals;
	}

	public void create(animalEntity animal) {
		animals.put(animal.getIndex(), animal);
		animal.getIndex();
	}

	public void edit(Integer index, animalEntity animal) {
		animals.put(index, animal);
	}

	public void delete(Integer index) {
		animals.remove(index);
	}

	public animalEntity getOne(Integer index) {
		return animals.get(index);
	}

}
