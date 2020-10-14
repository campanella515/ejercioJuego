package juego;

public class Arma extends Item {
	//atributos globales 
	private int agravio;
	private int peso;
	//get and set
	public int getAgravio() {
		return agravio;
	}
	public void setAgravio(int agravio) {
		this.agravio = agravio;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public Arma() {
		this.agravio=2;
		this.peso=2;
		
	}
	public Arma(Arma arma) {
		this.agravio=arma.agravio;
		this.peso=arma.peso;
	}
	//constructores
	public Arma(String nombre,int valor,Habilidad[] acciones,int agravio,int peso) {
		
		
		super(nombre,valor,acciones);//llamamos a los atributos ya inicializados en la clase madre
		//this.nombre=nombre;
	    //	this.valor=valor;
		
		//for(int i=0;i<acciones.length;i++)
			//this.acciones[i]=acciones[i];
		
		this.agravio=agravio;
		this.peso=peso;
				
	}
	
	//visualizares
	 @Override
	public void visualizar() {
		 System.out.println("El nombre es :" +nombre);
		System.out.println("El agravio es "+agravio);
		System.out.println("el valor del arma es "+valor);
		
		System.out.println("Las acciones del arma son: ");
		if(acciones!=null)
		for(int i=0;i<acciones.length;i++)
			if(acciones[i]!=null)			
				System.out.println(acciones[i]);
		
		
	}
	 @Override
	public void visualizarBasico() {
		System.out.println("El agravio es "+agravio);
		System.out.println("El valor del arma es "+valor);
	}

}
