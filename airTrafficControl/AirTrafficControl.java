package airTrafficControl;

import java.util.Scanner;

/**
 * Question and contions:
            you have to design a automated air traffic control
			you will get all info about flight and type of request
			such as landing,take off and emergency landing
			
    Terminologies:
	  1.Touchdown:flight touches the ground
	  2.Time to halt:after-touchdown-fully stopped
	  3.takeoff
	  4.Taxing-plane to designated stop for both(landing & takeoff)
	  
	Flight Details(speed-200km/ph for both)
	
	 Type              max weight(ton)        time to halt/take off         
     ATR                      12                   30 sec
     AirBus	                  20                   40 sec
	 Boeing                   40                   50 sec
     cargo                    100                  60 sec

    logic:
    (time to halt) directly	propotional to (Weight)
	which mean if weight will less time to get reduce for halt(vice versa)
	which mean if weight will high time to get increase for halt(vice versa)
    
    weight(%)   ex=(9/12)*100 for ATR-->75%	
	 w>75%--------------full time
	 50%<w<75%----------fulltime-(10% of full time)
	 w<50%--------------fulltime-(20% of full time)
	 
	example:
	    ATR takes 30 sec with 9+tonnes(>75%) 
		ATR takes 27 sec with 6+ to 9 tonnes(50%<w<75%)10% of 30=3 so 30-3=27
	    ATR takes 24 sec with less than 6 tonnes(<50%)20% of 30=6 s0 30-6=26
	 
    RUN WAYS
runway-time to both
	r1-40 sec   //speed   distane=speed*time (km/ses)*sec
	r2-60 sec
	r3-80 sec
	r4-90 sec
	
	it is always advice to allot a runway to x flight which has atleast +10 sec extra
	
// explain with flight details --^

Task of ATCotrl

req -->takeoff,landing,emergency landing

get flight details
    type of flight and weight
compute correct runway 
assign rw to flight and mark rw as engaged
free rw after take off or landing(taxing)
 
mul req in short time - each hand seperate or use queue if possible
after prov sol 15 sec bf pr init

mistake: 
		ATR - r1 with 45 sec(runway) + 15 sec (waitT)	 
	 
	 
test case:
		landing - higher priority
		shortest rw -first allot
		more than > 4 req add to Q
		req not wait more than 3 times(fifo)
		emer-longest 
		
test case(cont)
  hand - 2 TF & 2L f 2 cargo & 2 ATR
  h - 4 L for ATR wei vary
......
last  -- show run way status

17:51 a doubt 

 SAMPLE INPUT
REQ 
1.Take off
2.Landing
3.Emergency Landing
 plane type
 atr,airbus,...
palne we 
>15 ..10-15 ...<10

SAMPLE OUTPUT
	landig app for airbus with weight in r1
	Touch down will happen in 15 sec // not cal for runway 
	the plane will stop after  35 sec 0f touch down
    r1 will be ready for next req in 1 minute	
	 
 * @author KanaagalakshmiS
 *
 */
public class AirTrafficControl extends Thread {
	
	static void getDetails(int option,String fname,int fweight) {
		String chooseoption = null;
		switch(option) {
		case 1:chooseoption=new String("Landing");break;
		case 2:chooseoption=new String("takeoff");break;
		case 3:chooseoption=new String("emergency landing");break;
		
		
		}
		int calcTime=Flight.computeT(fname,fweight);
		int runwaynum=Runway.runway(calcTime);
		Request r=new Request(fname,fweight,calcTime,runwaynum,chooseoption);
		switch(option){
		
			case 1://takeoff
				
				r.start();
				try {
					sleep(50);
				}
				catch(Exception e) {
					
				}
				break;
				
case 2://takeoff
				
				r.start();
				try {
					sleep(50);
				}
				catch(Exception e) {
					
				}
				break;
				
case 3://takeoff
	
	r.start();
	try {
		sleep(50);
	}
	catch(Exception e) {
		
	}
	break;
	

		
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Choose an option:\n 1.TAKE OFF\n 2.LANDING\n 3.EMERGENCY LANDING\r\n");
		int i=0;
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();
			while(i!=1) {
				sc.nextLine();
			System.out.println("Please enter plane type:\r");
			String fname=sc.nextLine();
			System.out.println("Please give the weight of flight");
			int fweight=sc.nextInt();
			getDetails(option,fname,fweight);
			System.out.println("Do not you want to continue-press 1");
			i=sc.nextInt();
			
			}
		
	}

}
