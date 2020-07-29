package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import heap.GenericHeap;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		// Neighbour hashmap is initialized
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {
			Vertex nbrvtx = vtces.get(key);
			nbrvtx.nbrs.remove(vname);
		}

		vtces.remove(vname);
	}

	public int numEdges() {
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		int count = 0;

		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			// If one of the key is not present or it is already present in their nbrs
			// hashmap
			// then no need to update
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			// If one of the key is not present or it is not present in their nbrs hashmap
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("--------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}

		System.out.println("--------------------");
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {
		// to avoid infinite calls as if A is a neighbour of B
		// then B is the neighbour of A and hence each recursive call
		// will be consumed in calling each other if Hashmap was absent as it keeps
		// the track of the elements been already visited
		processed.put(vname1, true);

		// direct edge
		Vertex vtx = vtces.get(vname1);
		if (vtx.nbrs.containsKey(vname2))
			return true;

		// call the neighours
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
				return true;
			}
		}

		return false;
	}

	private class Pair {
		String vname;
		// psf -> path so far
		String psf;
	}

	// Breadth First Search - SHORTEST DISTANCE
	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();
		// Queue approach similar to level order traversal in BT
		LinkedList<Pair> queue = new LinkedList<>();

		// src pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// Add this pair in queue
		queue.addLast(sp);

		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();

			// if pair already exists then no need to iterate
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// Registering the visiting nodes in hashmap
			processed.put(rp.vname, true);

			// accessing the nbrs hashmap of rp
			Vertex rpvtx = vtces.get(rp.vname);

			// Checking for direct edges
			if (rpvtx.nbrs.containsKey(dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs key set
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}
		}
		return false;
	}

	// Depth First Search
	public boolean DFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();
		// Queue approach similar to level order traversal in BT
		LinkedList<Pair> stack = new LinkedList<>();

		// src pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// Add this pair in queue
		stack.addFirst(sp);

		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();

			// if pair already exists then no need to iterate
			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// Registering the visiting nodes in hashmap
			processed.put(rp.vname, true);

			// accessing the nbrs hashmap of rp
			Vertex rpvtx = vtces.get(rp.vname);

			// Checking for direct edges
			if (rpvtx.nbrs.containsKey(dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs key set
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}
		}
		return false;
	}

	// Breadth First Traversal
	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();
		// Queue approach similar to level order traversal in BT
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			
			if( processed.containsKey(key))
			{
				continue;
			}
			
			// key pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// Add this pair in queue
			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				// if pair already exists then no need to iterate
				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// Registering the visiting nodes in hashmap
				processed.put(rp.vname, true);

				// accessing the nbrs hashmap of rp
				Vertex rpvtx = vtces.get(rp.vname);

				System.out.println(rp.vname + " via " + rp.psf);
				

				// nbrs key set
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
	}
	
	// Depth First Traversal
		public void DFT() {

			HashMap<String, Boolean> processed = new HashMap<>();
			// Queue approach similar to level order traversal in BT
			LinkedList<Pair> stack = new LinkedList<>();

			ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			for (String key : keys) {
				
				if( processed.containsKey(key))
				{
					continue;
				}
				
				// key pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;

				// Add this pair in queue
				stack.addFirst(sp);

				while (!stack.isEmpty()) {
					Pair rp = stack.removeFirst();

					// if pair already exists then no need to iterate
					if (processed.containsKey(rp.vname)) {
						continue;
					}

					// Registering the visiting nodes in hashmap
					processed.put(rp.vname, true);

					// accessing the nbrs hashmap of rp
					Vertex rpvtx = vtces.get(rp.vname);

					System.out.println(rp.vname + " via " + rp.psf);
					

					// nbrs key set
					ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

					for (String nbr : nbrs) {
						if (!processed.containsKey(nbr)) {
							Pair np = new Pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							stack.addFirst(np);
						}
					}
				}
			}
		}
		
		// Cyclic or not
		public boolean isCyclic() {

			HashMap<String, Boolean> processed = new HashMap<>();
			// Queue approach similar to level order traversal in BT
			LinkedList<Pair> queue = new LinkedList<>();

			ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			for (String key : keys) {
				
				if( processed.containsKey(key))
				{
					continue;
				}
				
				// key pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;

				// Add this pair in queue
				queue.addLast(sp);

				while (!queue.isEmpty()) {
					Pair rp = queue.removeFirst();

					// if pair already exists then it has occurred twice
					// Hence it is cyclic
					if (processed.containsKey(rp.vname)) {
						return true;
					}

					// Registering the visiting nodes in hashmap
					processed.put(rp.vname, true);

					// accessing the nbrs hashmap of rp
					Vertex rpvtx = vtces.get(rp.vname);

					// nbrs key set
					ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

					for (String nbr : nbrs) {
						if (!processed.containsKey(nbr)) {
							Pair np = new Pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
			}
			
			return false;
		}
		
		// Connected or not
		public boolean isConnected() {

			// flag will keep the count of the total number of componenets
			// in the graph
			int flag = 0;
			
			HashMap<String, Boolean> processed = new HashMap<>();
			// Queue approach similar to level order traversal in BT
			LinkedList<Pair> queue = new LinkedList<>();

			ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			for (String key : keys) {
				
				if( processed.containsKey(key))
				{
					continue;
				}
				
				flag++;
				// key pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;

				// Add this pair in queue
				queue.addLast(sp);

				while (!queue.isEmpty()) {
					Pair rp = queue.removeFirst();

					// if pair already exists then no need to iterate
					if (processed.containsKey(rp.vname)) {
						continue;
					}

					// Registering the visiting nodes in hashmap
					processed.put(rp.vname, true);

					// accessing the nbrs hashmap of rp
					Vertex rpvtx = vtces.get(rp.vname);

					// nbrs key set
					ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

					for (String nbr : nbrs) {
						if (!processed.containsKey(nbr)) {
							Pair np = new Pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
			}
			
			if(flag == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		// Tree or not
		public boolean isTree()
		{
			return !isCyclic() && isConnected();
		}

		// getComponenets
		public ArrayList<ArrayList<String>> getComponenets() {

			ArrayList<ArrayList<String>> ans = new ArrayList<>();
			
			HashMap<String, Boolean> processed = new HashMap<>();
			// Queue approach similar to level order traversal in BT
			LinkedList<Pair> queue = new LinkedList<>();

			ArrayList<String> keys = new ArrayList<>(vtces.keySet());
			for (String key : keys) {
				
				if( processed.containsKey(key))
				{
					continue;
				}
				
				// for new component create a new ArrayList
				ArrayList<String> subans = new ArrayList<>();
				
				// key pair
				Pair sp = new Pair();
				sp.vname = key;
				sp.psf = key;

				// Add this pair in queue
				queue.addLast(sp);

				while (!queue.isEmpty()) {
					Pair rp = queue.removeFirst();

					// if pair already exists then no need to iterate
					if (processed.containsKey(rp.vname)) {
						continue;
					}

					// Registering the visiting nodes in hashmap
					processed.put(rp.vname, true);

					// accessing the nbrs hashmap of rp
					Vertex rpvtx = vtces.get(rp.vname);

					subans.add(rp.vname);
					
					// nbrs key set
					ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

					for (String nbr : nbrs) {
						if (!processed.containsKey(nbr)) {
							Pair np = new Pair();
							np.vname = nbr;
							np.psf = rp.psf + nbr;
							queue.addLast(np);
						}
					}
				}
				
				ans.add(subans);
			}
			
			return ans;
		}
		
		// PRIMS ALGORITHM
		private class PrimsPair implements Comparable<PrimsPair>{
			String vname;
			String acqvname;
			int cost;
			@Override
			public int compareTo(PrimsPair other) {
				
				return other.cost - this.cost;
			}
		}
		
		public Graph prims()
		{
			Graph mst = new Graph();
			HashMap<String , PrimsPair> map = new HashMap<>();
			GenericHeap<PrimsPair> heap= new GenericHeap<>();
			
			// Creating Hashmap and heap
			for(String key : vtces.keySet())
			{
				PrimsPair np = new PrimsPair();
				np.vname = key;
				np.acqvname = null;
				np.cost = Integer.MAX_VALUE;
				
				heap.add(np);
				map.put(key , np);
			}
			
			// till the heap is not empty
			while(! heap.isEmpty())
			{
				// remove a pair
				PrimsPair rp = heap.remove();
				map.remove(rp.vname);
				
				
				// adding vertices to mst
				// 1st vertex --> only vertex and no edge
				if( rp.acqvname == null)
				{
					mst.addVertex(rp.vname);
				}
				else
				{
					mst.addVertex(rp.vname);
					mst.addEdge(rp.vname, rp.acqvname, rp.cost);
				}
				
				// nbrs
				for(String nbr : vtces.get(rp.vname).nbrs.keySet())
				{
					// if nbr is present in the hashmap and the heap then do the work
					if( map.containsKey(nbr))
					{
						
						// get the old and new cost
						int oc = map.get(nbr).cost;
						int nc = vtces.get(rp.vname).nbrs.get(nbr);
						
						
						// update the pair
						if( nc < oc)
						{
							PrimsPair gp = map.get(nbr);
							gp.acqvname = rp.vname;
							gp.cost = nc;
							
							heap.updatePriority(gp);
						}
					}
				}
				
			}
			
			return mst;
		}
		
		// DIJKSTRA ALGORITHM
				private class DijkstraPair implements Comparable<DijkstraPair>{
					String vname;
					String psf;
					int cost;
					@Override
					public int compareTo(DijkstraPair other) {
						
						return other.cost - this.cost;
					}
				}
				
				public HashMap<String , Integer> dijkstra( String src)
				{
					HashMap<String , Integer> ans = new HashMap<>();
					
					HashMap<String , DijkstraPair> map = new HashMap<>();
					GenericHeap<DijkstraPair> heap= new GenericHeap<>();
					
					// Creating Hashmap and heap
					for(String key : vtces.keySet())
					{
						DijkstraPair np = new DijkstraPair();
						np.vname = key;
						np.psf = "";
						np.cost = Integer.MAX_VALUE;
						
						if(key.equals(src))
						{
							np.psf = key;
							np.cost = 0;
						}
						
						heap.add(np);
						map.put(key , np);
					}
					
					// till the heap is not empty
					while(! heap.isEmpty())
					{
						// remove a pair
						DijkstraPair rp = heap.remove();
						map.remove(rp.vname);
						
						
						// adding vertices to ans hashmap
						ans.put(rp.vname , rp.cost);
						
						
						// nbrs
						for(String nbr : vtces.get(rp.vname).nbrs.keySet())
						{
							// if nbr is present in the hashmap and the heap then do the work
							if( map.containsKey(nbr))
							{
								
								// get the old and new cost
								int oc = map.get(nbr).cost;
								int nc = rp.cost + vtces.get(rp.vname).nbrs.get(nbr);
								// new cost = cost so far + present cost
								
								// update the pair
								if( nc < oc)
								{
									DijkstraPair gp = map.get(nbr);
									gp.psf = rp.psf + nbr;
									gp.cost = nc;
									
									heap.updatePriority(gp);
								}
							}
						}
						
					}
					
					return ans;
				}
}





