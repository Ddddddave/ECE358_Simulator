import java.util.*;

public class Main {
	Queue buffer = new LinkedList<Double>();
	static double queueType;
	static double ticks;
	static double lambda;
	static double packetLength;
	static double serviceTime;
	static double transmissionTime;
	static int bufferSize = -1;
	
	public static void main(String[] args) {
		queueType = Double.parseDouble(args[0]);
		ticks = Double.parseDouble(args[1]);
		lambda = Double.parseDouble(args[2]);
		packetLength = Double.parseDouble(args[3]);
		serviceTime = Double.parseDouble(args[4]);
		transmissionTime = packetLength/serviceTime;
			
		//queueType == 0 means M/D/1
		//queueType == 1 means M/D/1/K 
		if(queueType == 1){
			bufferSize = Integer.parseInt(System.console().readLine("Enter buffer size: "));
		}
		
		for(int i = 0; i < 20; i++){
			System.out.println(exponential_rv(5));
		}
	}
	
	public int next_arrive(){
		int next_time = 0;
		return next_time;
	}
	
	public int next_service(){
		int next_service = 0;
		return next_service;
	}
	
	public static double exponential_rv(double lambda){
		//(-1/lambda)* ln(1-U)
		return (-1/lambda)* Math.log(1- Math.random());
	}

}
