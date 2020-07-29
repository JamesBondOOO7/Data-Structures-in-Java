package heap;

public class Car implements Comparable<Car>{

	int speed;
	int price;
	String color;
	
	public Car(int speed , int price , String color)
		{
			this.speed = speed;
			this.price = price;
			this.color = color;
		}
	
		@Override 
		public String toString()
		{
			return "S:" + this.speed + " P:" + this.price + " C:" + this.color;
		}

		@Override
		public int compareTo(Car other) {
			// On the basis of priority of speed
			// speed high --> priority increases
			return this.speed - other.speed;
			
			// On the basis of color
			//return this.color.compareTo(other.color);
			
			// On the basis of price
			// price low --> priority increases
			// return other.price - this.price;
		}
}
