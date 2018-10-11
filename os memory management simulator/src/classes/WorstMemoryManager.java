package classes;



public class WorstMemoryManager extends MemoryManager {


	public WorstMemoryManager(float timeStep) {
		super(timeStep);

	}

	@Override
	protected void fit(Process proc) {

		if(memoryMap.get(0)==null)
			memoryMap.add(new MemorySlot(proc , new LimTuple(0,proc.getSize())));

		for (int i = 0 ; true ; i++){

			if (memoryMap.get(i+1)==null){					
				float firstLim = memoryMap.get(i).getLimits().getSecondLim();
				memoryMap.set(i+1,new MemorySlot(proc,new LimTuple(firstLim,proc.getSize()+firstLim)));
				return;	
			}

		}
	}

}