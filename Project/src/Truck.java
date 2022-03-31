
public class Truck extends Vehical {

	
	int Cargocapacity;

	
	public Truck() {
		super();

	}

	public Truck(String make, String model, int weight, String regNo ,int c) {
		super(make, model, weight, regNo);
		this.Cargocapacity=c;
	}

	public int getCargocapacity() {
		return Cargocapacity;
	}

	public void setCargocapacity(int cargocapacity) {
		Cargocapacity = cargocapacity;
	}
	
	
}
