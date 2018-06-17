package drools.spring.example.facts;

import java.io.Serializable;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("10m")
public class HAEvent implements Serializable{

	private static final long serialVersionUID = 1L;

	public HAEvent() {
		super();
	}
}
