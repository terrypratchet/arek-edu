package demo.synonims;

public class Dough implements Money{

	public Dough(){
		System.out.println("money:dough");
	}
	
	@Override
	public String toString() {
		return "Dough []";
	}
	
}
