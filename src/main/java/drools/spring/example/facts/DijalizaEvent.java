package drools.spring.example.facts;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("1m")
public class DijalizaEvent implements Serializable{

	private static final long serialVersionUID = 1L;

	public DijalizaEvent() {
		super();
	}
	
}
