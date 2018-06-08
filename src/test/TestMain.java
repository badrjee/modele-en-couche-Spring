package test;

import java.util.HashMap;
import java.util.Map;

import model.Client;
import presentation.Vue;

public class TestMain {

	public static void main(String[] args) {
		
		
		
		//----------------CREATION DE CLIENT----------------
		Vue vue = new Vue();
//		vue.createClient("arnaud");
//		vue.createClient("Steven");
//		vue.createClient("Fabien");
		
		//----------------AFFICHAGE LISTE CLIENT----------------
		vue.showAllClients();
		
		
		System.out.println("----------------AFFICHER UN CLIENT----------------");
		vue.showClient(4);
		
	}

}
