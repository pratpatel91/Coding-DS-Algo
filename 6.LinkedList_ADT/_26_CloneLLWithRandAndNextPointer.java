/*
import java.util.HashMap;

public class _26_CloneLLWithRandAndNextPointer
{

	// Should return the head of the copied linked list the
	// output will be 1 if successfully copied
	Node copyList(Node head) 
	{
	    //storing addresses of all nodes in order to
	    //map them using random pointers
	   HashMap<Node,Node> map = new HashMap<>();
	   Node traversalNode = head;
	   Node clonedLLHead = null;
	          
	   //traversing ll to create new nodes for all the nodes
	   while(traversalNode!=null)
	   {
	        clonedLLHead=new Node(traversalNode.data);
	        map.put(traversalNode,clonedLLHead);
	        traversalNode=traversalNode.next;
	   }
	   
	    traversalNode = head;
	    clonedLLHead=map.get(traversalNode);
	    
	   while(traversalNode!=null)
	   {
	       //handling next pointers
	        clonedLLHead.next=map.get(traversalNode.next);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	        //handling random pointers 
	        clonedLLHead.arb=map.get(traversalNode.arb);
	        
	        traversalNode=traversalNode.next; //updating pointer
	        clonedLLHead=clonedLLHead.next; //updating pointer
	   }
	    
	     return map.get(head);
	}

}
*/