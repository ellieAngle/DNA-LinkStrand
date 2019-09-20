//Ellie Angle, Ben Chin
public class LinkStrand implements IDnaStrand {
	private class Node {
		String info;
	    Node next;
	    public Node(String s) {
	       info = s;
	       next = null;
	    }
	}
	private Node myFirst, myLast;
	private long mySize;
	private int myAppends;
	
	private int myIndex;
	private int myLocalIndex;
	private Node myCurrent;
	   
	public LinkStrand() {
		this("");
	}
	
	public LinkStrand(String s) {
		initialize(s);
	}

	@Override
	public long size() {
		return mySize;
	}

	@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		myLast = myFirst;
		mySize = source.length();
		myAppends = 0;
		
		myIndex = 0;
		myLocalIndex = 0;
		myCurrent = myFirst;
	}

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}
	
	@Override
	public String toString() {
		Node currentNode = myFirst;
		StringBuilder strand = new StringBuilder(); 
		while (currentNode != null) {
			strand.append(currentNode.info);
			currentNode = currentNode.next;
		}
		return strand.toString();
	}

	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += dna.length();
		myAppends += 1;
		return this;
	}

	@Override
	public IDnaStrand reverse() {
		LinkStrand newLS = new LinkStrand();
		Node travNode = new Node(myFirst.info);
		Node currentN = myFirst;
		currentN = currentN.next;
		while (currentN != null) {
			Node middle = new Node(currentN.info);
			middle.next = travNode;
			travNode = middle;
			currentN = currentN.next;
			
		}
		Node my1First = travNode;
		Node myLastl = null;
		while(travNode != null) {
			StringBuilder copy = new StringBuilder(travNode.info);
			copy.reverse();
			StringStrand ss = new StringStrand(copy.toString());
			travNode.info = ss.toString();
			if (travNode.next == null) {
				myLastl = travNode;
			}
			travNode = travNode.next;
		}
		newLS.mySize = mySize;
		newLS.myFirst = my1First;
		newLS.myLast = myLastl;
		return newLS;
	}

	@Override
	public int getAppendCount() {
		return myAppends;
	}

	@Override
	public char charAt(int index) {
		
<<<<<<< HEAD
		return 0;
=======
		while (myIndex != index) {
			myIndex ++;
			myLocalIndex ++;
			//if (myCurrent.next == null && myLast.info.length() < myLocalIndex) 
			if (myCurrent.next == null && myIndex > index)		
				throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
			if (myLocalIndex >= myCurrent.info.length()) {
				myLocalIndex = 0;
				myCurrent = myCurrent.next;
			}
			
		}
		
		return myCurrent.info.charAt(myLocalIndex);
>>>>>>> 60d13aad9561c3956b27e5aafbab40ba893d3b48
	}
}

