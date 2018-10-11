package classes;

public class LimTuple {
	
	private float firstLim;
	private float SecondLim;
	
	public LimTuple (float firstLim, float SecondLim ){
		
		this.firstLim = firstLim;
		this.SecondLim =SecondLim;
		
		
	}
	
	public float getFirstLim() {
		return firstLim;
	}
	public void setFirstLim(float firstLim) {
		this.firstLim = firstLim;
	}
	public float getSecondLim() {
		return SecondLim;
	}
	public void setSecondLim(float secondLim) {
		SecondLim = secondLim;
	}

	@Override
	public String toString() {
		return "LimTuple [firstLim=" + firstLim + ", SecondLim=" + SecondLim + "]";
	}
	
	

}
