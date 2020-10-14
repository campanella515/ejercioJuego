package juego;

public class Armadura extends Item {
	//atributos globales
	private int armadura;
	private int peso;
	//get and set
	
	public int getArmadura() {
		return armadura;
	}
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	//constructores 	
	public Armadura(){
		armadura=9;
		peso=10;
	}
	
	public Armadura(Armadura armadura) {
		this.armadura=armadura.armadura;
		this.peso=armadura.peso;
	}
	
	public Armadura(String nombre,int valor,Habilidad[] acciones,int armadura,int peso) {
		super(nombre,valor,acciones);
		//this.nombre=nombre;
		//this.valor=valor;
		
		//for(int i=0;i<acciones.length;i++)
			//this.acciones[i]=acciones[i];
		
		this.armadura=armadura;
		this.peso=peso;
	}
	//visualizadore
	 @Override
	public void visualizar() {
		System.out.println("el nombre de la armadura es "+nombre);
		System.out.println("el valor de la armadura es "+valor);		
		System.out.println("el peros de la armadura es "+peso);
		System.out.println("La armadura "+armadura);
		
		System.out.println("Las acciones son ");
		if(acciones!=null )
			for(int i=0;i<acciones.length;i++)			
				if(acciones[i]!=null)
					System.out.println("la acciones"+i+" es "+acciones[i]);
				
	}
	 @Override
	public void visualizarBasico() {
		System.out.println("El nombre de la armadura es "+nombre);
		System.out.println("El valor de la armadura es "+valor);
	}
	 
	public boolean esIgual(Item item)
		{
			boolean salida = true;
		
			if(this.nombre.equals(item.nombre) )
			{
				if(this.numhabi==item.numhabi)
				{
					for(int i = 0; i<item.numhabi;i++)
					{
						if(!this.tiene(item.acciones[i]))
						{
							salida=false;
						}
					}
				}
				else
					salida =false;
			}
			else
				salida =false;
			
			
			
			
			return salida;
		}
}
