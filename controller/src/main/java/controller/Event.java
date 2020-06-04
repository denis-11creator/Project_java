package controller;
import java.util.Random; 
import java.util.concurrent.TimeUnit;


/**
 * These classes determine the events that happens in the game 
 * @author ARISTIDE KOLOKO
 *@see Controller
 */
public class Event  {
		
	private boolean gameLost=false;
	private boolean gotDiamond=false;
	private boolean doorReach=false;
	public Event(){
		
	}
	public boolean getGameLost(){
		return gameLost;
	}
	public boolean getGotDiamond(){
		return gotDiamond;
	}
	public boolean getDoorReach(){
		return doorReach;
	}
	public char[][] movement(int l, char[][] map){
		gotDiamond=false;
		doorReach=false;
		map=this.mouvementRocher(map);
		map=this.mouvementIA(map);
		int px=0;
		int py=0;
		
		for(int i = 0; i<40; i++){ // searching for the player's coords
			for(int j = 0; j<40; j++){
				if(map[i][j] == 'p'){
					px = j;
					py = i;
					i = 40;
					j = 40;
				}
			}
		} 
		
	// Up
        if(l==90){
            if (map[py][px-1]!='m' && map[py][px-1]!='r' ){ //if keystroke is upkey (z)
            	if(map[py][px-1]=='d'){ //if the player catches a diamond
            		gotDiamond=true;
            	}
            	 if(map[py][px-1]=='e'){//if the player reaches the door
               		doorReach=true;
               	}
            	 else{
		            map[py][px] = 'y';
		            map[py][px-1] = 'p';
            	 }
	            try {
	                   TimeUnit.MILLISECONDS.sleep(30); //wait for 30 ms
	            } catch (InterruptedException e) {
	                   // TODO Auto-generated catch block
	                   e.printStackTrace();
	            }
            }
            return map;
           
     }
// Left
     if(l==81){ //same functionalities as the last condition.
    	 if (map[py-1][px]!='m' && map[py-1][px]!='r' ){
    		 if(map[py-1][px]=='d'){
         		gotDiamond=true;
         	}
    		 if(map[py-1][px]=='e'){
          		doorReach=true;
          	}
    		 else{
	            map[py][px] = 'y';
	            map[py-1][px] = 'p';
    		 }
            
            try {
                   TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
                  
            }
    	 }
            return map;
           
     }
// Down 
     if(l==83){//same functionalities as the last condition.
    	 if (map[py][px+1]!='m' && map[py][px+1]!='r' ){
    		 if(map[py][px+1]=='d'){
         		gotDiamond=true;
         	}
    		 if(map[py][px+1]=='e'){
           		doorReach=true;
           	}
     		 else{
	            map[py][px] = 'y';
	            map[py][px+1] = 'p';
     		 }
            try {
                   TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
            }
    	 }
         return map;
     }
// Right
     if(l==68){//same functionalities as the last condition.
    	 if (map[py+1][px]!='m' && map[py+1][px]!='r' ){
    		 if(map[py+1][px]=='d'){
         		gotDiamond=true;
         	}
    		 if(map[py+1][px]=='e'){
           		doorReach=true;
           	}
     		 else{
	            map[py][px] = 'y';
	            map[py+1][px] = 'p';
     		 }
            try {
                   TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
            }
            return map;
    	 }
     }
		if(l==27){ // if the escape key is activated, the game is closed.
			System.exit(0);
		}
		
		if(l==82){
			//reset();
		}
		return map;
		
	}

	

	
	public char[][] mouvementRocher(char[][] map){
		
		for(int i = 0; i<40; i++){
			for(int j = 0; j<40; j++){
				if((map[i][j] == 'r' || map[i][j]=='d')&& map[i][j+1] == 'y'){
					if(map[i][j+2]=='p'){
						gameLost=true;
					}
					if(map[i][j]=='r'){
						map[i][j+1]='r'; 
					}
					else{
						map[i][j+1]='d'; 
					}
					map[i][j]='y';
					
				}
			}
		}
		try {
			TimeUnit.MILLISECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	
	public char[][] mouvementIA(char[][] map){
		Random rand = new Random();
		//Thread t = new Thread();
		//t.start();
		for(int i = 0; i<40; i++){
			for(int j = 0; j<40; j++){
				if(map[i][j] == 'b' || map[i][j] == 'f' || map[i][j] == 'u' ){
					int  n = rand.nextInt(4) + 1;
						if(map[i][j-1] == 'p' && n == 1){
							gameLost=true;
						}
						if(map[i][j-1] == 'y' && n == 1){
							map[i][j-1] = map[i][j];
							map[i][j] = 'y';
						}
						//left
						if(map[i-1][j] == 'p' && n == 2){
							gameLost=true;
						}
						if(map[i-1][j] == 'y' && n == 2){
							map[i-1][j] = map[i][j];
							map[i][j] = 'y';
						}
						//down
						if(map[i][j+1] == 'p' && n == 3){
							gameLost=true;
						}
						if(map[i][j+1] == 'y' && n == 3){
							map[i][j+1] = map[i][j];
							map[i][j] = 'y';
						}
						//right
						if(map[i+1][j] == 'p' && n == 4){
							gameLost=true;
						}
						if(map[i+1][j] == 'y' && n == 4){
							map[i+1][j] = map[i][j];
							map[i][j] = 'y';
						}
						
					}
				}
			}
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//t.stop();
		return map;
	}
	

}


