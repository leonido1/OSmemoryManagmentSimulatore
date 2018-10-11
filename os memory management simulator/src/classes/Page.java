package classes;

import java.util.ArrayList;

public class Page extends Process {

	public Page(float size, float startTime, String name, float cpuTime) {
		super(size, startTime, name, cpuTime);
		
	}


	static public ArrayList<Page> breakProcessToPages (Process proc , float pageSize){
		
		ArrayList<Page> pagesList = new ArrayList<>();
		float procSize = proc.getSize();
		
		while (procSize > 0){
			
			pagesList.add(new Page(pageSize, proc.getStartTimeInMs(), proc.getProcsessName(), proc.getCPURunTimeLeft()));
			procSize -= pageSize;
		
		}
		
		
		return pagesList;
		
	}



}
