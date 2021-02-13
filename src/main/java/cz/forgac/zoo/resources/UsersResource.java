package cz.forgac.zoo.resources;

import cz.forgac.zoo.entities.animalEntity;
import cz.forgac.zoo.managers.mujManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("animals") // /api/users
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

	@Inject
	private mujManager manager;

	@GET
	public Response getAnimals(){
		return Response.ok(manager.getAll()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response giveBirthToAnAnimal(animalEntity animal) {
		manager.create(animal);
		return Response.ok().build();
	}

	@PUT
	@Path("{index}")
	public Response changeAge(@PathParam("index") Integer index, animalEntity animal) {
		manager.edit(index, animal);
		return Response.ok().build();
	}

	@DELETE
	@Path("{index}")
	public Response slaughterAnimal(@PathParam("index") Integer index) {
		manager.delete(index);
		return Response.ok().build();
	}

	@GET
	@Path("{index}")
	public Response getAnimal(@PathParam("index") Integer index) {
		return Response.ok(manager.getOne(index)).build();
	}
}