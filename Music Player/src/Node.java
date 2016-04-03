/**
 * This Node Class shall use the Song Class in order to embody the data that
 * will make up the Node that will be added to the LinkedList.
 * @author Harold Agnote
 *
 */
public class Node
{
	/**
	 * The Song that will be assigned to the particular Node.
	 */
	private Song value;
	/**
	 * The next Node that this Node will point to.
	 */
	private Node next;
	
	/**
	 * Constructor takes in a Song object and assigns it to the value for the
	 * Node. It then sets the next Node reference as null.
	 * @param q		The Song that will be assigned to the value.
	 */
	public Node( Song q )
	{
		value = q;
		next = null;
	}
	
	/**
	 * Overloaded Constructor takes in a Song object and another Node.
	 * It then assigns the value to the Song object and the next as the
	 * next Node that will be referenced.
	 * @param q		The Song that will be assigned to the value.
	 * @param n		The next Node that will be assigned to the next value.
	 */
	public Node( Song q, Node n ) 
	{
		value = q;
		next = n;
	}
	
	/**
	 * Method gets the next Node after this Node.
	 * @return		The Node after this Node.
	 */
	public Node getNext() 
	{
		return next;
	}
	
	/**
	 * Method sets the next Node after this Node
	 * @param n		The Node after this Node that will be assigned to next.
	 */
	public void setNext( Node n ) 
	{
		next = n;
	}
	
	/**
	 * Method gets the value of this Node.
	 * @return		The value of this Node. (In this case the Song Object value).
	 */
	public Song getValue() 
	{
		return value;
	}
	
	/**
	 * Method sets the value of this Node to a Song Object.
	 * @param q		The Song that will be assigned to the value.
	 */
	public void setValue( Song q ) 
	{
		value = q;
	}
	
}