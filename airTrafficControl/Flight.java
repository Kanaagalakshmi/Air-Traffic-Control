package airTrafficControl;

public class Flight {
    static int percent;
    static int computeT(String fname,int fweight) {
    	if(fname.equalsIgnoreCase("AirBus")) {
    	   percent=fweight*100/20;
    	   if(percent>=75) {
    		   return 40;
    	   }
    	   else if(percent>=50&&percent<=75) {
    		   return 36;
    	   }
    	   else {
    		   return 32;
    	   }
    	}
    	else if(fname.equalsIgnoreCase("ATR")) {
    		percent=fweight*100/12;
    		 if(percent>=75) {
      		   return 30;
      	   }
      	   else if(percent>=50&&percent<=75) {
      		   return 37;
      	   }
      	   else {
      		   return 34;
      	   }
    	}
    	else if(fname.equalsIgnoreCase("Boeing")) {
    		percent=fweight*100/40;
    		 if(percent>=75) {
      		   return 50;
      	   }
      	   else if(percent>=50&&percent<=75) {
      		   return 45;
      	   }
      	   else {
      		   return 40;
      	   }
    	}
    	else  {
    		percent=fweight*100/100;
    		 if(percent>=75) {
      		   return 60;
      	   }
      	   else if(percent>=50&&percent<=75) {
      		   return 54;
      	   }
      	   else {
      		   return 48;
      	   }
    	}
    }
}
