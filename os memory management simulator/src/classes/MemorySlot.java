package classes;

public class MemorySlot {

	private Process pro;
	private LimTuple limits;
	
	public MemorySlot (Process pro, LimTuple limits){
		
		this.pro=pro;
		this.limits=limits;
		
	}
	
	
	@Override
	public String toString() {
		return "MemorySlot [pro=" + pro.getProcsessName() + ", limits=" + limits + "]";
	}


	public Process getPro() {
		return pro;
	}
	public void setPro(Process pro) {
		this.pro = pro;
	}
	public LimTuple getLimits() {
		return limits;
	}
	public void setLimits(LimTuple limits) {
		this.limits = limits;
	}
	
	
	
	
}
