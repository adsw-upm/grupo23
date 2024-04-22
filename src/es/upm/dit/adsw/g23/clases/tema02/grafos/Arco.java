package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.Objects;

public class Arco<T> {
	private T nodo1;
	private T nodo2;
	public double peso;
	
	public Arco(T desde, T hacia) {
		this(desde, hacia, 1.0);
	}
	
	public Arco(T desde, T hacia, double peso) {
		this.nodo1 = desde;
		this.nodo2 = hacia;
		this.peso = peso;
	}
	
	public T uno() {
		return this.nodo1;
	}
	
	public T otro(T uno) {
		if(uno.equals(this.nodo1)) {
			return this.nodo2;
		} else if(uno.equals(this.nodo2)) {
			return this.nodo1;
		} else {
			throw new IllegalArgumentException("el arco no contiene al nodo indicado");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nodo1, this.nodo2, this.peso);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this)
	        return true;
	    if (!(o instanceof Arco))
	        return false;
		Arco<Object> otro = (Arco<Object>) o;	
	    Object o1, o2;
		if(this.nodo1.equals(otro.nodo2)) {
			o1 = otro.nodo2;
			o2 = otro.nodo1;
		} else {
			o1 = otro.nodo1;
			o2 = otro.nodo2;
		}
		return o1 == this.nodo1 && o2.equals(this.nodo2) && otro.peso == this.peso;
	}
	
	public String toString() {
		return this.nodo1 + "->" + this.nodo2 + " " + this.peso;
	}
		
}
