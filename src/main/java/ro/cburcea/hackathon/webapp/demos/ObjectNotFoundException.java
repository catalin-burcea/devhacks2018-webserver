package ro.cburcea.hackathon.webapp.demos;

public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(Long id) {
		super("Could not find object " + id);
	}
}