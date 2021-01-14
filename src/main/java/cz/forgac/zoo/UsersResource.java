package cz.forgac.zoo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("animals") // /api/users
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

	static HashMap<Integer, HashMap<String, String>> animals = new HashMap<>();
	static Integer index = 0;

	@GET
	public Response getAnimals(){
		return Response.ok(animals).build();
	}

	@POST
	public Response giveBirthToAnAnimal(@FormParam("name") String name, @FormParam("age") String age) {
		if(name != null && age != null ){
			HashMap<String,String> newAnimal = new HashMap<>();
			newAnimal.put("name", name);
			newAnimal.put("age", age);
			animals.put(index, newAnimal);
			index++;
			return Response.ok(animals).build();
		} else {
			return Response.ok("ENTER PARAMETERS").build();
		}
	}

	@GET
	@Path("{index}")
	public Response getAnimal(@PathParam("index") Integer index) {
		if(index != null && animals.get(index) != null){
			return Response.ok(animals.get(index)).build();
		} else {
			return Response.ok("NOT FOUND").build();
		}
	}

	@DELETE
	@Path("{index}")
	public Response slaughterAnimal(@PathParam("index") Integer index) {
		if(index != null){
			animals.remove(index);
		}
		return Response.ok(animals).build();
	}

	@PUT
	@Path("{index}")
	public Response changeAge(@PathParam("index") Integer index,@FormParam("name") String name ,@FormParam("age") String age) {
		if(animals.get(index) != null && index != null && name != null && age != null){
			HashMap<String,String> newAnimal = new HashMap<>();
			newAnimal.put("name", name);
			newAnimal.put("age", age);
			animals.put(index, newAnimal);
		}
		return Response.ok(animals).build();
	}





}