package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
	}


	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
				"Un nouvel enseignant doit avoir 0 heures prévues");
	}

	@Test
	public void testAjouteHeures() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 20, 0);

		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}

	@Test
	public void testEstEnSousService(){

		//Cas : en sous-service
		//L'enseignat fait 40h d'intervention il est en dessous de 192h
		untel.ajouteEnseignement(uml, 8, 12, 20);
		assertTrue(untel.enSousService(), "L'enseignant doit etre en sous service");

		//Cas : pas en sous-service
		//ajout de 160h
		untel.ajouteEnseignement(uml, 20, 36, 24 );
		untel.ajouteEnseignement(java, 20, 24, 36);
		assertFalse(untel.enSousService(), "L'enseignant ne doit pas être en sous service");

	}


	@Test
	public void testResteAPlanifier() {
		untel.ajouteEnseignement(uml, 0, 10, 0); // 10h TD pour UML
		assertEquals(192 - 10, untel.resteAPlanifier(uml, TypeIntervention.TD),
				"Il devrait rester 182 heures à planifier pour l'enseignant pour les TD d'UML");

		untel.ajouteEnseignement(java, 0, 20, 0); // 20h TD pour Java
		assertEquals(192 - 30, untel.resteAPlanifier(java, TypeIntervention.TD),
				"Il devrait rester 162 heures à planifier pour l'enseignant pour les TD de Java");

		untel.ajouteEnseignement(uml, 0, 5, 0); // 5h TD pour UML
		assertEquals(192 - 30 - 5, untel.resteAPlanifier(uml, TypeIntervention.TD),
				"Il devrait rester 157 heures à planifier pour l'enseignant pour les TD d'UML");
	}




}