package model;
/**
 * determines the character's view when he changes position 
 * @author MIRLEINE BOUANGA
 *
 */
public class CharacterView {

	char[][] CView = new char[15][15];
	char[][] v_map;
	
	public CharacterView(char[][] c_map) {
		v_map=c_map;
	}
	 
	public void moveView(){ 
		int Px=0;
		int Py=0;
		for (int i=0; i<40; i++){
			for (int j=0; j<40; j++){
				if (v_map[i][j]=='p'){
					Px=j;
					Py=i;
					//System.out.print("VOICI DONC PX et PY"+ Px +":"+ Py);
					i=40;
					j=40;
				}
			}
		}
		
		int x=0;
		int y=0;
		for(int i=Py-7; i<=Py+7; i++ ){
			for (int j=Px-7; j<=Px+7; j++){
				if(j>0 && i>0 && j<40 && i<40){
					CView[y][x]=v_map[i][j];
				}
				else{
					CView[y][x]='z';
				}
				//System.out.print(CView[y][x]);
				x++;
			}
			y++;
			x=0;
		}


	}
	public char[][] getCView(){
		this.moveView();
		return CView;
	}


}
