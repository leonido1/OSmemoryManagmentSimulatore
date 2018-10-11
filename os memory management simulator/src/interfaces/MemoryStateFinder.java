package interfaces;

import java.util.ArrayList;

import classes.MemorySlot;

public interface MemoryStateFinder {

	  public ArrayList<MemorySlot> memoryInGivenTime(String studentId, float eachProcessRunTime,float arrivalTimeInterval, float time);
	
}
