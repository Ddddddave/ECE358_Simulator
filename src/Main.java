
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
