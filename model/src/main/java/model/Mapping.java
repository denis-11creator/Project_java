package model;

import java.sql.SQLException;

import model.dao.ExampleDAO;

public class Mapping {

	private String carte="";
	public Mapping() {
		
	}

	public String getMap(){
		return carte;
	}
       /**
        * @author DUVAL FOTSO FOALENG
        * @param lvl
        * @return
        */
	public char[][] loadMap(int lvl){
		
		ExampleDAO bddfetch = new ExampleDAO();
		Example example = new Example(0, carte);
		try {
			example = bddfetch.getExampleById(lvl);
			carte = example.toString();
			//System.out.print(carte+"\n\n");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("||erreur load map||");
		}
		int k=0;
		char tablemap[][] = new char[40][40];
		for (int i=0; i<40; i++){
			for (int j=0; j<40; j++){
				if(carte.charAt(k)!='\n'){
					tablemap[i][j]=carte.charAt(k);
				}
				k++;
			}
		}
		return tablemap;
		
	}
	public void loadStones(){
		
	}
	public void loadWalls(){
		
	}
	public void loadMonsters(){
		
	}
	public void loadCharacter(){
		
	}
}
