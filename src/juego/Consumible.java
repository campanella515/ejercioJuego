package juego;

public class Consumible extends Item{
	//atributos generales
	private int cantidad;
	private int consumible;
	
	//get and set
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
//constructores
	public Consumible(){
		cantidad=0;
	}
	
	public Consumible(Consumible consumible) {
		this.consumible=consumible.consumible;		
	}
	public Consumible(String nombre,int valor,Habilidad[] acciones,int cantidad) {
		super(nombre,valor,acciones);//atributos heredados que ya estan inicializados
		//this.nombre=nombre;
		//this.valor=valor;
		//for(int i=0;i<acciones.length;i++) {
			//this.acciones[i]=acciones[i];
		//}
		this.cantidad=cantidad;
			
	}
	//visualizadores
	 @Override
	public void visualizar() {
		System.out.println("El nombre del consumible es "+nombre);
		System.out.println("El valor del consumible es "+valor);
		
		System.out.println("Las acciones son :");
		if(acciones!=null)
		 for(int i=0;i<acciones.length;i++)
			if(acciones[i]!=null)
				System.out.println("Las acciones son "+acciones[i]);
		
		System.out.println("La cantidad es "+cantidad);
	}
	 @Override
	public void visualizarBasico() {
		 System.out.println("El nombre del consumible es "+nombre);
		System.out.println("El valor del consumible es "+valor);
		System.out.println("La cantidad es "+cantidad);
	}

}
