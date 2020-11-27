package airTrafficControl;

public class Request extends Thread {
	String fname;
	int fweight;
	int calcTime;
	int runwaynum;
	String option;
	Request(String fname,int fweight,int calcTime,int runwaynum,String option){
		this.fname=fname;
		this.fweight=fweight;
		this.calcTime=calcTime;
		this.runwaynum=runwaynum;
		this.option=option;
	}
	public  void run(){
		try {
		System.out.format("%s approval for %s with weight in %d\nTouch down will happen in %d sec \nThe plane will stop after %d secs of touch down\nrunway%d will be ready for next req in %d sec	",option,fname,fweight,calcTime,runwaynum,calcTime);
	    sleep(1000*calcTime);
	    Runway.change(runwaynum);
		}
		catch(Exception e) {
			System.out.print(e);
		}
		}
	
	
}
