package edu.eci.cvds.tdd.registry;
import java.util.HashMap; 

public class Registry {
	private HashMap<Integer, Person> votantes;

	public Registry(){
    		votantes = new HashMap<Integer, Person>();
   	 }

    	public RegisterResult registerVoter(Person p) {
		Integer id = p.getId();
		RegisterResult resultado_registro = RegisterResult.VALID;
		boolean esta_vivo = p.isAlive();
		int edad = p.getAge();
		
		if (votantes.containsKey(id)) {
			resultado_registro = RegisterResult.DUPLICATED;
		} else if (!esta_vivo){
			resultado_registro = RegisterResult.DEAD;
		} else if (edad < 0 || edad > 135) {
			resultado_registro = RegisterResult.INVALID_AGE;
		} else if (edad < 18) {
			resultado_registro = RegisterResult.UNDERAGE;
		} else {
			votantes.put(id, p);
	        	resultado_registro = RegisterResult.VALID;
		}	
		
		return resultado_registro;
    	}
}
