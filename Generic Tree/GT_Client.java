package tree.GenericTree;

public class GT_Client {

	public static void main(String[] args) {
		GenericTree tree = new GenericTree();
		tree.display();
		// 60 3 41 2 17 0 16 0 15 1 21 0 24 2 33 0 84 0
		
		/* The tree is like
		 * 
		 * 					   60
		 * 					  /|\
		 * 					 / | \
		 * 					/  |  \
		 * 				   /   |   \
		 * 				  41  15    24
		 * 				 /|    |    |\
		 * 				/ |    |    | \
		 * 			   /  |    |    |  \
		 * 			  17  16   21   33  84
		 * 
		 */
	}

}
