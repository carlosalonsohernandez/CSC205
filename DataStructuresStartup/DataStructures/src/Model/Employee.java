package DataStructuresStartup.DataStructures.src.Model;

public class Employee {
	private String name;
	
	private long id;
	public Employee(long id, String name) {
		
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
