package heap;

import generics.Car;

public class GH_Client {

	public static void main(String[] args) {
		Car [] cars = new Car[5];
		cars[0] = new Car(1000 , 1000000 , "Red");
		cars[1] = new Car(4000 , 3000000 , "Blue");
		cars[2] = new Car(1000 , 5000000 , "Red-Black");
		cars[3] = new Car(3000 , 2500000 , "White");
		cars[4] = new Car(2000 , 2000000 , "Green");
		
		GenericHeap<Car> heapg = new GenericHeap<Car>();
		heapg.add(cars[0]);
		heapg.add(cars[1]);
		heapg.add(cars[2]);
		heapg.add(cars[3]);
		heapg.add(cars[4]);
		
		// HIGHER SPEED HAS HIGHER PRIORITY
		
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());
		System.out.println(heapg.remove());

	}

}
