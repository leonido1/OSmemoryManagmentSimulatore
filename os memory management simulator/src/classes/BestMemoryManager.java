package classes;



public class BestMemoryManager extends MemoryManager {


	private float defaultBestSize = 10000000;
	

	public BestMemoryManager(float timeStep) {
		super(timeStep);
		
	}

	
	
	@Override
	protected void fit(Process proc) {
		
		if(memoryMap.get(0)==null){
			memoryMap.add(new MemorySlot(proc , new LimTuple(0,proc.getSize())));
			return;
		}
			int bestIndex = 0;
			float bestSpace = defaultBestSize;
			
			for (int i = 0 ; true ; i++){

				if (memoryMap.get(i+1)==null)
					break;	
				
			
			
				MemorySlot currentSlot = memoryMap.get(i);
				MemorySlot nextSlot = memoryMap.get(i+1);
				float freeSpace = currentSlot.getLimits().getSecondLim() - nextSlot.getLimits().getFirstLim();
				
				if(freeSpace >= proc.getSize()){
				  
					if ( bestSpace > freeSpace ){
						bestSpace = freeSpace;
						bestIndex = i;
						
					}
					
					
				}
			
			}

			float startLim =  memoryMap.get(bestIndex).getLimits().getSecondLim();
			memoryMap.add(bestIndex+1, new MemorySlot(proc, new LimTuple(startLim, startLim + proc.getSize() )));

	}



	@Override
	protected void unfit(Process proc) {
		// TODO Auto-generated method stub
		
	}
		
				
		
	



}
