package airTrafficControl;

public class Runway extends Thread {
	static boolean runway1=true;
	static boolean runway2=true;
	static boolean runway3=true;
	static boolean runway4=true;
	int totaltime=0;
	static int num=0;
	public static void change(int num){
	  if(num==1) {
		  runway1=true;
	  }
	  else if(num==2) {
		  runway2=true;
	  }
	  else if(num==3) {
		  runway3=true;
	  }
	  else {
		  runway4=true;
	  }
	}
     static int runway(int time) {
  
    	 if(time<=40&&runway1==true) {
    		 runway1=false;
    		num=1;
    		
    		
    		 
    	 }
    	 else if(time<=60&&runway2==true) {
    		 runway2=false;
    		 num=2;
    		
    
    	 }
    	 else if(time<=80&&runway3==true) {
    		 runway3=false;
    		  num=3;
    	
    
    	 }
    	 else if(time<=90&&runway4==true){
    		 runway4=false;
    		num=4;
    		 
    	
    	 }
    	 
    	 else{
    	}
    	 return num;
    	 
    	
     }
}
