package classes;

public class Process implements Comparable<Process> {

	private float size;
	private float startTimeInMs;
	private String procsessName;
	
	public String getProcsessName() {
		return procsessName;
	}

	public void setProcsessName(String procsessName) {
		
		this.procsessName = procsessName;
	}


	private float CPURunTimeLeft;

    public Process(){}
	
	public Process(float size, float startTime, String name,float cpuTime) {
		
		this.size = size;
		this.startTimeInMs = startTime;
		this.procsessName = name;
		this.CPURunTimeLeft = cpuTime;
		
	}
	
	public float getCPURunTimeLeft() {
		return CPURunTimeLeft;
	}


	public void setCPURunTimeLeft(float cPURunTimeLeft) {
		CPURunTimeLeft = cPURunTimeLeft;
	}


	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}


	public float getStartTimeInMs() {
		return startTimeInMs;
	}


	public void setStartTimeInMs(float startTimeInMs) {
		this.startTimeInMs = startTimeInMs;
	}



	@Override
	public String toString() {
		return "Process size:" + size + ", startTimeInMs:" + startTimeInMs  + ", Process Name:" +  procsessName;
	}

	@Override
	public int compareTo(Process pOther) {
		
		return (int) (Math.ceil(this.startTimeInMs-pOther.startTimeInMs));
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Process) )
			return false;
		Process other = (Process) obj;
		if (procsessName == null) {
			if (other.procsessName != null)
				return false;
		} else if (!procsessName.equals(other.procsessName))
			return false;
		return true;
	}



}
