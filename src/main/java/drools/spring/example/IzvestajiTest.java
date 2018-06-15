package drools.spring.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import drools.spring.example.facts.Izvestaj;
import drools.spring.example.services.IIzvestajiService;

public class IzvestajiTest {

	@Autowired
	static
	IIzvestajiService izs;
	
	public static void main(String[] args) {
		
		ArrayList<Izvestaj> izvestaji = izs.getHronicne();
		
		for(Izvestaj i : izvestaji) {
			System.out.println(i.toString());
		}
	}

}
