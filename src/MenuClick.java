import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuClick extends MenuCommands {
	
	int width;
	int height;
	StateBasedGame sbg;

	public void initClick(StateBasedGame statebased, int w, int h) {
		width=w;
		height=h;
		sbg = statebased;
	}
	
	public void MainClick(int button, int x, int y){
		if((x>(width-350) && y>(height-80) && (y>(40) && y<(110))))
	     {
	         if(button==0){
	        	 System.exit(0);
	         }
	     }
	     
	     //
	     //starting the game
	     //This first section is for AI singleplayer.
	     if((x<(width/4)  && y>height/2))
	     {
	    	 if(button==0){
	        	IsThereAI = true;
	        	Screen=1;
	         }
	     }
	     else if((x<(width/2)  && y>height/2))
	     {
	    	 if(button==0){
		        	IsThereAI = false;
		        	Screen=1;
	         }
	     }
	    
	}
	
	public void LevelClick(int button, int x, int y) throws SlickException{
		if(IsThereAI){
	    	 if((x<((width/5))))
	    	 {
	    		 if(button==0){
	    			 System.out.println("click");
	    			 Map.mapControl=0;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*1) && x<((width/5)*2)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=1;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*2) && x<((width/5)*3)))
	    	 {
	    		 if(button==0){ 
	    			 Map.mapControl=2;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*3) && x<((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=3;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }

	    	 if((x>((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=4;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=true;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	     }
	     
	     //
	     //Set up for the Multiplayer maps
	     else{
	    	 if((x<((width/5)*1)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=0;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=false;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*1) && x<((width/5)*2)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=1;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=false;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*2) && x<((width/5)*3)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=2;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=false;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*3) && x<((width/5)*4)))
	    	 {
	    		 if(button==0){
	    			 Map.mapControl=3;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=false;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	    	 if((x>((width/5)*4))){
	    		 if(button==0){
	    			 Map.mapControl=4;
	    			 Map.mapinit();
	    			 theme.stop();
	    			 Map.IsThisAI=false;
	    			 sbg.enterState(Barnacle.map);
	    		 }
	    	 }
	     } 
		
	}
	
	
}