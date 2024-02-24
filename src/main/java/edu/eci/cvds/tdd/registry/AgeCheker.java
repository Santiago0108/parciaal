package edu.eci.cvds.tdd.registry;

public class AgeCheker {
    public boolean isMinor(int edad){
        if (edad >=0 && edad < 18){
            return true;
        }
        else{
            return false;
        }
    }
}
