

/**
 * A priority queue implementation using max heap
 * @author Saveri Pal
 *
 */
public class PriorityQ {
	
	 /**
	  * Array of type Task that stores (jobs,priority)
	  */
	 public Task[] maxHeap;
	 /**
	  * size of heap
	  */
	 private int heapSize;
		
	    
	    /**
	     * Constructs a PriorityQ
	     */
	    public PriorityQ()
	    {   
	    	maxHeap = new Task[100]; 
	    	for(int i = 0; i < maxHeap.length; i++) 
	    	{
	    		maxHeap[i] = new Task(" ", 0);
	    	}
	    	heapSize = 0;
	    }
	    

	    /**
	     * Adds string s with priority p to the queue
	     * @param s  a job
	     * @param p  priority of the job
	     */
	    public void add(String s, int p)
	    {
	    	heapSize++;
	        maxHeap[heapSize-1]= new Task(s,p);
	        sort();
	    		    	
	    }
	    
	    /**
	     * Sorts a heap containg jobs with priorities
	     */
	    public void sort() 
	    { 
	        int n = heapSize; 
	  
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(n, i); 
	    }
	    
	    /**
	     * Max heapifies
	     * @param n size of heap
	     * @param i largest priority
	     */
	    public void heapify(int n, int i) 
	    { 
	        int largest = i; // parent
	        int left = 2*i + 1; // left child
	        int right = 2*i + 2; // right child
	  
	        // If left child is larger than largest so far
	        if (left < n && maxHeap[left].p > maxHeap[largest].p) 
	            largest = left; 
	  
	        // If right child is larger than largest so far 
	        if (right < n && maxHeap[right].p > maxHeap[largest].p) 
	            largest = right; 
	  
	        // If largest is not parent 
	        if (largest != i) 
	        { 
	            Task swap = new Task(" ",0);
	        	swap.p = maxHeap[i].p; 
	        	swap.s = maxHeap[i].s;
	        	maxHeap[i].p = maxHeap[largest].p; 
	        	maxHeap[i].s = maxHeap[largest].s; 
	        	maxHeap[largest].p = swap.p; 
	        	maxHeap[largest].s = swap.s; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(n, largest); 
	        } 
	    } 
	    
	    
	    /**
	     * Returns a string whose priority is maximum
	     * @return a string/job with max priority
	     */
	    public String returnMax()
	    {
	    	
	    	return maxHeap[0].s;
	    }
	    
	    /**
	     * Extracts the highest priority string from the priority queue
	     * And returns it
	     * And removes it from the priority queue
	     * @return highest priority string/job from queue
	     */
	    public String extractMax()
	    {
	    	String highestPriorityString = maxHeap[0].s;
	    	remove(0);
	    	return highestPriorityString; 	
	    }
	    
	    /**
	     * Removes the i-th Array index element from the priority queue
	     * @param i index of element to be removed
	     */
	    public void remove(int i)
	    {
	    	maxHeap[i].p = maxHeap[heapSize-1].p;
	    	maxHeap[i].s = maxHeap[heapSize-1].s;
	    	heapSize = heapSize-1;
	    	sort();	
	    }
	    
	    /**
	     * Decrements the priority of i-th element by k
	     * @param i element whose priority needs to be reduced
	     * @param k amount by which the priority needs to be removed
	     */
	    public void decrementPriority(int i, int k)
	    {
	    	maxHeap[i].p -= k;
	    	sort();
	    }
	    
	    /**
	     * Returns a priority array, B containing the priorities of all elements in A
	     * B[i] = Key(A[i])
	     * @return
	     */
	    public int[] priorityArray()
	    {
	    	int B[]= new int[heapSize];
	    	for(int i = 0;i<heapSize;i++)
	    	{
	    		B[i] = maxHeap[i].p;
	    		//System.out.println(maxHeap[i].p);
	    	}
	    	
	    	return B;
	    }
	    
	    /**
	     * Returns key(A[i]), where A is the priority queue
	     * @param i element
	     * @return priority of the element
	     */
	    public int getKey(int i)
	    {
	    	
	    	return maxHeap[i].p;
	    }
	    
	    /**
	     * Returns value(A[i]), where A is the priority queue
	     * @param i 
	     * @return string s
	     */
	    public String getValue(int i)
	    {
	    	
	    	return maxHeap[i].s;
	    }
	    
	    /**
	     * Check if heap is empty of not
	     * @return true or false depending on empty or not
	     */
	    public boolean isEmpty()
	    {
	    	boolean temp;
	    	temp = (heapSize==0)?true:false;
	    	return temp;
	    }
	    
	    

}
