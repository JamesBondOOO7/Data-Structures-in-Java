package tries;

public class Client {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("Messi");
		trie.addWord("Manan");
		trie.addWord("Pujit");
		trie.addWord("Jatin");
		trie.addWord("Renz");
		trie.addWord("Sujay");
		trie.addWord("Manas");
		
		trie.addWord("arts");
		trie.addWord("art");
		trie.display();
		
		System.out.println("********************************");
		
		trie.remove("arts");
		trie.remove("art");
		trie.display();
		System.out.println("********************************");
		
		System.out.println(trie.search("Manan"));
		System.out.println(trie.search("Hello"));
		System.out.println(trie.search("Manas"));
		
		
	}

}
