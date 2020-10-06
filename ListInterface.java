/**
 * This interface indicates the public methods that need to be implemented for Homework 3 of
 * CMP-338, Fall 2015. 
 * 
 * @author Sameh Fakhouri
 *
 */

public interface ListInterface<I extends Comparable<? super I>> {
	
	

	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of <b>Element</b>s that are currently in the list.
	 */
	
	public int size();

	
	
	/**
	 * This method is called to determine if the list is empty.
	 * 
	 * @return 	Returns <b>true</b> if the list is empty, otherwise it returns <b>false</b>. 
	 */
	
	public boolean isEmpty();

	
	
	/**
	 * This method is called to add the specified Element to the end of the list.
	 * 
	 * @param 	element	A reference to the element to be added to the end of the list.
	 * 					All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void add(I element);
	
	
	
	/**
	 * This method is called to add the specified Element to the list at the given index.
	 * 
	 * @param 	element	A reference to the element to be added to the list. 
	 * 					All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @param 	index 	Indicates the position at which to add the specified Element.
	 * 					Using and index = 0, indicates that the Element being added should
	 * 					become the <b>head</b> of the list and should succeed even if
	 * 					the list is currently empty.
	 * 
	 * @return 	Returns <b>true</b> if the Element was successfully added at the given index.
	 * 			If the given index is invalid, this method returns <b>false</b>, indicating
	 * 			that the specified Element was not added to the list.
	 * 
	 * @see		java.lang.Comparable
	 */
	public boolean add(I element, int index);
	
	

	/**
	 * This method is called to add the specified Element to the list in sorted order. More
	 * specifically, the Elements preceding the specified Element must be "less than" the
	 * specified Element, and the Elements following the specified Element must be "greater
	 * that or equal to" the specified Element.
	 * 
	 * @param 	element 	A reference to the <b>element</b> being added, in sorted order, 
	 * 					to the list. All Elements being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void addSorted(I element);
	
	
	
	/**
	 * This method is called to retrieve the Element at the specified index.
	 * 
	 * @param 	index	Indicates the position from which to retrieve the Element.
	 * 
	 * @return	Returns a reference to the <b>Element</b> at the given index, or <b>nullL</b>
	 * 			if the given index is invalid.
	 */
	public I get(int index);
		
	
	
	/**
	 * 
	 * This method is called to replace the element at the specified <b>index</b> with the specified
	 * <b>obj</b>. The method then returns the replaced element or <b>null</b> if no element exists
	 * at the specified <b>index</b>.
	 * 
	 * @param element	A reference to the <b>element</b> that will replace the current element in the list.
	 * 
	 * @param index Idicates the position in the list where the replacement should be made.
	 * 
	 * @return		If the replacement is successful, the method will return a reference to the replaced
	 * 				element. Otherwise, the method will return <b>null</b>.
	 */
	public I replace(I element, int index);

	
	
	/**
	 * This method is called to remove the Element at the specified index
	 * 
	 * @param 	index	Indicates the position from which to remove the Element.
	 * 
	 * @return	Returns <b>true</b> if the Element was successfully removed from the given index, 
	 * 			or <b>false</b> if the given index is invalid.
	 */
	public boolean remove(int index);

	
	
	/**
	 * This method removes all Elements from the list, making the list empty.
	 */
	public void removeAll();
	
}
