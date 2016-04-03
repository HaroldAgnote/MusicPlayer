/**
 * This class is the LinkedList that will take note of the references to the
 * first and last Node contained in the LinkedList and use these references in
 * order to perform the necessary functions to manipulate and access the date
 * within the LinkedList.
 * @author Harold Agnote
 *
 */
public class LinkedList
{
	/**
	 * The first Node that is contained in the LinkedList
	 */
	private Node first;
	/**
	 * The last Node that is contained in the LinkedList. The next Node it will
	 * point to should be null.
	 */
	private Node last;
	
	/**
	 * Constructor initializes the first and last Node to a null value in order
	 * to prepare future Nodes to be added. 
	 */
	public LinkedList() 
	{
		first = null;
		last = null;
	}
	
	/**
	 * Method checks if the first Node is a null value, if so then there should
	 * not be another Node that the first one points to. Therefore, the LinkedList
	 * is empty.
	 * @return	True  - if first Node is null <br>
	 * 			False - if first Node is <b>not</b> null
	 */
	public boolean isEmpty() 
	{
		return first == null;
	}
	
	/**
	 * Method goes through each Node starting from the first and increments the
	 * <b>count</b> variable until the next Node is null. The method then returns
	 * the <b>count</b> variable.
	 * @return	The size of the LinkedList
	 */
	public int size() 
	{
		int count = 0;
		Node p = first;
		while( p != null ) 
		{
			count++;
			p = p.getNext();
		}
		return count;
	}
	
	/**
	 * Method retrieves a specified Node by starting onto the first Node and then
	 * getting the next Node until the specified index is reached. The Node is then
	 * returned.
	 * @param i		The specified index that the for loop will count up to.
	 * @return		The Node that is reached once the index has been reached.
	 */
	public Node get( int i ) 
	{
		Node prev = first;
		for(int j = 0; j < i; j++) 
		{
			prev = prev.getNext();
		}
		return prev;
	}
	
	/**
	 * Method overrides the toString() function. <br>
	 * Starting from the first Node, the method gets the value from the Node
	 * and retrieves the next Node in line until the Node is a null value.
	 * For each Node that is retrieved, the value is concatenated with the other
	 * values of the previous Nodes until the String variable is returned.
	 */
	public String toString() 
	{
		String str = "";
		Node n = first;
		while( n != null ) 
		{
			str = str + n.getValue();
			n = n.getNext();
		}
		return str;
	}
	
	/**
	 * Method takes in a Song object and checks if the LinkedList is empty. <br>
	 * If the LinkedList is empty, then the Song will be added as the first Node
	 * and have both the first and last Node point to that Node. <br>
	 * If the LinkedList is not empty, then the Song will be added to the last
	 * Node in line and have the previous Node point to that one while updating
	 * the appropriate references to that Node.
	 * @param q		The Song that will be assigned to the Node
	 */
	public void add( Song q ) 
	{
		if( isEmpty() ) 
		{
			first = new Node( q );
			last = first;
		}
		else
		{
			Node n = new Node( q );
			last.setNext( n );
			last = n;
		}
	}
	
	/**
	 * Overloaded method is used when the program needs to add a Node in the
	 * middle of the LinkedList rather than the end. Method uses an index passed 
	 * in to pinpoint the location as to where the Node will be added.
	 *  
	 * @param q 	The Song that will be added to the LinkedList
	 * @param i		The index of the location of where the Node will be added
	 */
	public void add( Song q, int i )
	{
		if( i < 0 || i > size() ) 
		{
			System.out.println("Index out of bounds.");
		} 
		else 
		{
			if( i == 0 )
			{
				first = new Node( q, first );
				if( last == null )
				{
					last = first;
				}
			} 
			else 
			{
				Node prev = get( i - 1 );
				prev.setNext( new Node( q, prev.getNext() ) );
				if( prev.getNext().getNext() == null ) 
				{
					last = prev.getNext();
				}
			}
		}
	}
	
	/**
	 * Method takes in an index of a Node containing a Song that will be 
	 * removed from the LinkedList. The method assures that the previous Node
	 * will not reference the Node that will be removed, but rather the Node
	 * after it. If the first Node is being removed, then the first Node will
	 * be updated so that it will refer to the next one. If the last Node is
	 * being removed, the last Node will be updated so that it refers to null.
	 * 
	 * @param i		The index of the Node that will be removed from the LinkedList.
	 * @return		The removed Node from the LinkedList.
	 */
	public Node remove( int i )
	{
		Node n = null;
		if( i < 0 || i >= size() )
		{
			System.out.println("Index out of bounds.");
		} 
		else 
		{
			if( i == 0 )
			{
				n = first;
				first = first.getNext();
				if( first == null )
				{
					last = null;
				}
			} 
			else 
			{
				Node prev = get( i - 1 );
				n = prev.getNext();
				prev.setNext( prev.getNext().getNext() );
				if( prev.getNext() == null ) 
				{
					last = prev;
				}
			}
		}
		return n;
	}
	
	/**
	 * Overloaded method searches the LinkedList for a Node that represents a 
	 * passed in Object that is desired to be removed from the LinkedList. Once 
	 * found, the method will perform functions to remove the Node from the
	 * LinkedList. 
	 * 
	 * @param q		The Song that the LinkedList will search for the Node that
	 * 				contains the similar Object
	 * @return		The removed Node from the LinkedList
	 */
	public Node remove( Song q )
	{
		Node n = null;
		if( !isEmpty() ) 
		{
			if( q.equals( first.getValue() ) ) 
			{
				n = first;
				first = first.getNext();
				if( first == null ) 
				{
					last = null;
				}
			} 
			else 
			{
				Node prev = first;
				
				while( prev.getNext() != null && !prev.getNext().getValue().equals(q) )
				{
					prev = prev.getNext();
				}

				if( prev.getNext() == null )
				{
					n = null;
					System.out.println("Does not exist");
				} 
				else 
				{
					n = prev.getNext();
					prev.setNext( prev.getNext().getNext() );
					if( prev.getNext() == null ) 
					{
						last = prev;
					}
				}
			}
		}
		return n;
	}
}