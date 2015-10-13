import java.io.Console;
import java.util.*;

public class Main {
	
	//input parameters
	static int simDuration = 0; //in ticks
	static int packetLength = 0;
	static int bufferSize = 5;
	static double lambda =0;
	static double serviceTime = 0; //service time received by a packet, bit/seconds, need to be convert to bit/ticks later
	
	//simulation variables
	static Queue<Double> buffer = new LinkedList<Double>();
	static int bufferCount = 0;
	static int generateTime = 0;
	static int serveInterval =0;
	static int totalPacket = 0;
	static int packetLoss = 0;
	static double EN = 0;
	static double ET = 0;
	static double pIdle = 0;
	static double pLoss = 0;
	static double utilization = 0;
	public static void main(String[] args) {
//		Scanner scanner = new Scanner (System.in);
//		System.out.print("Enter the time duration of simulation");  
//		simDuration = Integer.parseInt(scanner.next())*1000000;
//		System.out.print("Enter the lambda");
//		lambda = Double.parseDouble(scanner.next());
//		System.out.print("Enter the length of single packet"); 
//		packetLength = Integer.parseInt(scanner.next());
//		System.out.print("Enter the service time received by a packet");
//		serviceTime = Double.parseDouble(scanner.next())/1000000;
//		System.out.print("Enter the buffer size"); 
//		bufferSize = Integer.parseInt(scanner.next());
		
		simDuration = 1 * 1000000;
		lambda = 200;
		packetLength = 5000;
		serviceTime = 1;
		
		
		utilization = (packetLength*lambda)/(serviceTime*1000000);
		serveInterval = (int)(packetLength/serviceTime);
		generateTime = (int) nextArrive(lambda);
		

		for(int i = 0; i<simDuration;i++){
			generatePacket();
			servePacket();			
			generateTime--;
			if(bufferCount > 0){
				serveInterval--;
			}
		}
		System.out.println(packetLoss);
		System.out.println(totalPacket);
		System.out.println(utilization);
	}
	
	public static void generatePacket(){
		if(generateTime ==0){
			if(bufferCount == bufferSize){
				packetLoss++;
			}else{
				buffer.add((double) 1);
				bufferCount++;
			}
			generateTime = (int) nextArrive(lambda);					
			totalPacket++;
		}
	}
	
	public static void servePacket(){
		if(serveInterval ==0){
			buffer.remove();
			bufferCount--;
			serveInterval = (int)(packetLength/serviceTime);
		}
	}
	
	public static double nextArrive(double lambda){
		//(-1/lambda)* ln(1-U)
		return (-1/lambda)* Math.log(1- Math.random())*1000000;
	}

}
