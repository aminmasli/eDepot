
public class Tanker extends Vehical {

	int LiquidCapacity;
	String LiquidType;
	
	
	
	
	public Tanker() {
		super();
	
	}
	
	
	public Tanker(String make, String model, int weight, String regNo,int lc,String lt) {
		super(make, model, weight, regNo);
		this.LiquidCapacity=lc;
		this.LiquidType=lt;
	}
	
	public int getLiquidCapacity() {
		return LiquidCapacity;
	}
	public void setLiquidCapacity(int liquidCapacity) {
		LiquidCapacity = liquidCapacity;
	}
	public String getLiquidType() {
		return LiquidType;
	}
	public void setLiquidType(String liquidType) {
		LiquidType = liquidType;
	}
	
	
	
	
	
	
	
	
	
	
}
