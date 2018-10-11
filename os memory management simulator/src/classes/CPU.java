package classes;

public class CPU {

	
	private Process runningProcess;

	
	public CPU (){
		
		this.runningProcess = null; //empty CPU
	}
	
	
	public boolean isEmpty(){
		
		if(runningProcess == null)
			return true;
		
		return false;
		
	}
	
	public Process getRunningProcess() {
		return runningProcess;
	}

	public void setRunningProcess(Process runningProcess) {
		this.runningProcess = runningProcess;
	}
	
	
	
	
	
}
