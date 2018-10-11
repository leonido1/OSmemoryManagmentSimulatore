package classes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import interfaces.MemoryStateFinder;

public abstract class MemoryManager implements MemoryStateFinder{


	protected int memMapSize = 100;
	protected ArrayList<MemorySlot> memoryMap;
	protected Queue<Process> readyQueue;
	protected PriorityQueue<Process> waitingQueue;
	protected CPU cpu;
	protected float timeStep;


	public MemoryManager(float timeStep){

		this.memoryMap = new ArrayList<MemorySlot>();
		inidtializeMemMap();
		this.readyQueue = new LinkedList<>();
		this.waitingQueue =new PriorityQueue<>();
		this.cpu = new CPU();
		this.timeStep = timeStep;

	}


	protected void inidtializeMemMap() {

		this.memoryMap.add(new MemorySlot(new Process(), new LimTuple(0, 0)));//fictitious process
		
		for ( int i = 1 ; i < memMapSize ; i++){
			this.memoryMap.add( null);

		}

	}


	protected abstract void  fit(Process proc);

	protected void unfit(Process proc) {

		for (int i = 0 ; i < memoryMap.size(); i++ ){

			
			if (memoryMap.get(i) != null){
				if (proc.equals( memoryMap.get(i).getPro()))
					memoryMap.remove(memoryMap.get(i));



			}
		}

	}



	protected ArrayList<Process> genarateProcessFromID(String ID,float eachProcessRunTime,float arrivalTimeInterval){

		ArrayList<Process> processList = new ArrayList<>();  

		for (int i = 0; i < ID.length(); i++) {

			char c = ID.charAt(i);
			float startTime = arrivalTimeInterval*i; 
			char name = (char) ('A'+i);
			String pname=  name+"";
			processList.add(new Process(Character.getNumericValue(c)*100+50, startTime, pname, eachProcessRunTime));

		}

		return processList;

	}



	protected ArrayList<MemorySlot> runSimulation(ArrayList<Process> processList, float endTime) {

		float currentTime=0;	
		this.waitingQueue.addAll(processList);


		while (currentTime <= endTime){

			if (!waitingQueue.isEmpty() && waitingQueue.peek().getStartTimeInMs()==currentTime){

				Process currentProc = waitingQueue.poll();
				fit(currentProc);
				readyQueue.add(currentProc);

			}

			if (cpu.isEmpty())
				cpu.setRunningProcess(readyQueue.poll());
			else{

				cpu.getRunningProcess().setCPURunTimeLeft(cpu.getRunningProcess().getCPURunTimeLeft()-timeStep);
				if (cpu.getRunningProcess().getCPURunTimeLeft() == 0){

					unfit(cpu.getRunningProcess());
					cpu.setRunningProcess(readyQueue.poll());

				}

			}

			currentTime+=timeStep;

		}

		ArrayList<MemorySlot> returnList = memoryMap;
		//reset memory map after simulation
		memoryMap = new ArrayList<MemorySlot>();

		return returnList;
	}


	public ArrayList<MemorySlot> memoryInGivenTime(String studentId, float eachProcessRunTime,float arrivalTimeInterval, float time) {

		ArrayList<Process> processList = this.genarateProcessFromID(studentId, eachProcessRunTime, arrivalTimeInterval);


		return runSimulation(processList, time);
	}




	public ArrayList<MemorySlot> getMemoryMap() {
		return memoryMap;
	}


	public void setMemoryMap(ArrayList<MemorySlot> memoryMap) {
		this.memoryMap = memoryMap;
	}













}
