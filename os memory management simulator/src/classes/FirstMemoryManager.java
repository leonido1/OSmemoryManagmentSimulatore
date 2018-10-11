package classes;



public class FirstMemoryManager extends MemoryManager {

	public FirstMemoryManager(float timeStep) {
		super(timeStep);

	} 


	@Override
	protected void fit(Process proc) {

		
		if(memoryMap.get(0) == null){
			memoryMap.set(0,new MemorySlot(proc , new LimTuple(0,proc.getSize())));
			return;
		}
			for (int i = 0 ; true ; i++){

				if (memoryMap.get(i+1)==null){
					
					float firstLim = memoryMap.get(i).getLimits().getSecondLim();
					memoryMap.set(i+1,new MemorySlot(proc,new LimTuple(firstLim,proc.getSize()+firstLim)));
					return;	
				}
			
			
				MemorySlot currentSlot = memoryMap.get(i);
				MemorySlot nextSlot = memoryMap.get(i+1);
				float freeSpace = currentSlot.getLimits().getSecondLim() - nextSlot.getLimits().getFirstLim();
				
				if(freeSpace >= proc.getSize()){
				    float startLim =  currentSlot.getLimits().getSecondLim();
					memoryMap.add(new MemorySlot(proc, new LimTuple(startLim, startLim + proc.getSize() )));
					
				}
			
			}

	}
}


