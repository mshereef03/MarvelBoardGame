package engine;

public class PriorityQueue {

	@SuppressWarnings("rawtypes")
	private Comparable[] elements;
	private int nItems;
	private int maxSize;

	public PriorityQueue(int size) {
		maxSize = size;
		elements = new Comparable[maxSize];
		nItems = 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert(Comparable item) {

		int i;
		for (i = nItems - 1; i >= 0 && item.compareTo(elements[i]) > 0; i--)
			elements[i + 1] = elements[i];

		elements[i + 1] = item;
		nItems++;
	}

	@SuppressWarnings("rawtypes")
	public Comparable remove() {
		nItems--;
		return elements[nItems];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	@SuppressWarnings("rawtypes")
	public Comparable peekMin() {
		return elements[nItems - 1];
	}

	public int size() {
		return nItems;
	}
	
	//my addition
	
	public void setNItems(int x) {
		nItems = x;
	}
	
	public void setElements(Comparable[]c) {
		elements = c;
	}
	
	public PriorityQueue exactClone() {
		PriorityQueue q = new PriorityQueue(maxSize);
		q.setNItems(nItems);
		Comparable[] c = new Comparable[maxSize];
		for(int i=0;i<maxSize;i++)c[i]=elements[i];
		q.setElements(c);
		
		return q;
		
	}
}
