package Homework3;

public class Problem {
	
	public static Vehicle[] generateVehicles() {

		Manufacture manufacture1 =  new Manufacture("BMW", "Germany");
		Manufacture manufacture2 =  new Manufacture("Tesla", "US");
		Manufacture manufacture3 =  new Manufacture("Mercedes", "Germany");
		Manufacture manufacture4 =  new Manufacture("Toyota", "Japan");
		
		
		Vehicle[] vehicles = new Vehicle[10];

		vehicles[0] = new HybridV("Toyota C-HR GR-S", new HybridEngine("F/INJ", 144, 2022, 1.8f, 1798), manufacture4);
		vehicles[1] = new BEV("Tesla S Plaid", new ElectricEngine("EV Motor", 1020, 2022, 1865), manufacture2);
		vehicles[2] = new ICEV("BMW M4", new CombustionEngine("V6", 265, 2018, 3.5f), manufacture1);
		vehicles[3] = new HybridV("BMW i8", new HybridEngine("V8", 369, 2022, 1.5f, 1355), manufacture1);
		vehicles[4] = new BEV("Tesla Y ", new ElectricEngine("EV Motor", 456, 2023, 1061), manufacture2);
		vehicles[5] = new ICEV("Mercedes GT 63 S ", new CombustionEngine("V8", 630, 2023, 4.0f ), manufacture3);
		vehicles[6] = new HybridV("Mercedes ONE", new HybridEngine("V6", 1049, 2023, 1.6f, 1599), manufacture3);
		vehicles[7] = new ICEV("Corolla", new CombustionEngine("I-4", 132, 2018, 1.8f), manufacture4);
		vehicles[8] = new BEV("Mercedes EQ", new ElectricEngine("EV Motor", 516, 2023, 1243), manufacture3);
		vehicles[9] = new ICEV("BMW X7", new CombustionEngine("V8", 523, 2022, 4.4f ), manufacture1);

		return vehicles;
	}

	public static void main(String[] args) {
		Vehicle[] vehicles = generateVehicles();
		for(int i=0; i<vehicles.length; i++) {
			vehicles[i].ShowCharacteristics();
		}
	}

}


abstract class Engine{
	protected String name;
	protected int horsePower;
	protected int yearMade;
	
	public Engine(String name, int horsePower, int yearMade) {
		this.name = name;
		this.horsePower = horsePower;
		this.yearMade = yearMade;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}


	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}
	
	abstract void showCharacteristics();
	
	protected void showEngineCharacteristics() {
		System.out.print("\nEngine Characteristics\n");
		System.out.print("\tEngine Name: " + name);
		System.out.print("\tYear Made: " + yearMade);
		System.out.print("\tHorse Power: " + horsePower);
	}
}


class CombustionEngine extends Engine {
	private float cylinderSize;
	
	public CombustionEngine(String name, int horsePower, int yearMade, float cylinderSize) {
		super(name, horsePower, yearMade);
		this.cylinderSize = cylinderSize;
	
	}

	@Override
	void showCharacteristics() {
		System.out.print("Engine Type: Combustion Engine");
		showEngineCharacteristics();
		System.out.print("\tCylinder Size: " + cylinderSize + "\n");
	}
	
}

class ElectricEngine extends Engine {
	private int batterySize;
	
	public ElectricEngine(String name, int horsePower, int yearMade, int batterySize) {
		super(name, horsePower, yearMade);
		this.batterySize = batterySize;
	}
	
	@Override
	void showCharacteristics() {
		System.out.print("Engine Type: Electric Engine");
		showEngineCharacteristics();
		System.out.print("\tBattery Size: " + batterySize + "\n");
	}
}

class HybridEngine extends Engine {
	private float cylinderSize;
	private int batterySize;
	
	public HybridEngine(String name, int horsePower, int yearMade,float cylinderSize,int batterySize) {
		super(name, horsePower, yearMade);
		this.cylinderSize = cylinderSize;
		this.batterySize = batterySize;
	}
	
	@Override
	void showCharacteristics() {
		System.out.print("Engine Type: Hybrid Engine");
		showEngineCharacteristics();
		System.out.print("\tCylinder Size: " + cylinderSize);
		System.out.print("\tBattery Size: " + batterySize+ "\n");
	}
	
}

class Manufacture{
	private String name;
	private String location;
	
	public Manufacture(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public void showCharacteristics() {
		System.out.print("Manufacture Characteristics:\n");
		System.out.print("\tManufacture: " + name);
		System.out.print("\tLocation: " + location + "\n\n\n");
	}
	
}

abstract class Vehicle{
	protected String name;
	
	public Vehicle(String name) {
		super();
		this.name = name;
	}

	abstract public void ShowCharacteristics();
}


class ICEV extends Vehicle{
	private CombustionEngine engine;
	private Manufacture manufacture;
	

	public ICEV(String name, CombustionEngine engine, Manufacture manufacture) {
		super(name);
		this.engine = engine;
		this.manufacture = manufacture;
	}


	@Override
	public void ShowCharacteristics() {
		System.out.print("Vehicle name: " + name + "\n");
		engine.showCharacteristics();
		manufacture.showCharacteristics();
	}
	
}

class BEV extends Vehicle{
	private ElectricEngine engine;
	private Manufacture manufacture;
	

	public BEV(String name, ElectricEngine engine, Manufacture manufacture) {
		super(name);
		this.engine = engine;
		this.manufacture = manufacture;
	}


	@Override
	public void ShowCharacteristics() {
		System.out.print("Vehicle name: " + name + "\n");
		engine.showCharacteristics();
		manufacture.showCharacteristics();
		
	}
	
}

class HybridV extends Vehicle{
	private HybridEngine engine;
	private Manufacture manufacture;
	
	
	

	public HybridV(String name, HybridEngine engine, Manufacture manufacture) {
		super(name);
		this.engine = engine;
		this.manufacture = manufacture;
	}


	@Override
	public void ShowCharacteristics() {
		System.out.print("Vehicle name: " + name + "\n");
		engine.showCharacteristics();
		manufacture.showCharacteristics();
	}
	
}