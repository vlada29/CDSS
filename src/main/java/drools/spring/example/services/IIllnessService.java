package drools.spring.example.services;

import java.util.ArrayList;

import drools.spring.example.facts.Illness;


public interface IIllnessService {
	public ArrayList<Illness> getAllIllnesses();
	public void createIllness(Illness i);
	public void updateIllness(Illness i);
	public void deleteIllness(Illness i);
}
