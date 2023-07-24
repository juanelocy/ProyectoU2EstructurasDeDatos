package pruebas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p1="luissssssss";
		String p2="luis";
		int resultado=p1.compareTo(p2);
		if(resultado<0) {
			System.out.print(p1+" es menor que "+ p2);
		}
		
		else if (resultado>0) {
			System.out.print(p2+" es menor que "+ p1);
		}	
		else {
			System.out.print(p1+" es igual que "+ p2);
		}
	}
}
