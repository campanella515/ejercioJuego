package juego;

import java.util.*;
public abstract class Item {

	public String nombre;		
	public  int valor;
	public Habilidad[] acciones;
	
	
	Scanner teclado=new Scanner(System.in);
	
	//----metodos get and set------
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Habilidad[] getAcciones() {
		return acciones;
	}
	public void setAcciones(Habilidad[] acciones) {
		this.acciones = acciones;
	}
	public int getNumhabi() {
		return numhabi;
	}
	public void setNumhabi(int numhabi) {
		this.numhabi = numhabi;
	}


	//Habilidad acciones=new Habilidad[5];
	
	//atributos propios para facilitar el trabajo
	int numhabi;
	
	public Item()
	{
		numhabi= 0;
		nombre="vacio";		
		valor = 0;
		
		acciones = new Habilidad[5];
		//creamos las posiciones
		for (int i = 0; i< acciones.length; i++)
		{
			acciones[i]= new Habilidad();
		}
	}
	public Item(Item items)
	{
		this.numhabi = items.numhabi;
		this.nombre=items.nombre;	
		this.valor = items.valor;
		
		this.acciones = new Habilidad[5];
		for (int i = 0; i< this.acciones.length; i++)
		{
			this.acciones[i] = items.acciones[i];
		}
	}
	public Item(String nombre, int valor, Habilidad[] acciones)
	{
		this.numhabi = 0;
		this.nombre=nombre;	
		this.valor = valor;
		
		//this.acciones = acciones;
		
		this.acciones = new Habilidad[5];
	
		for (int i = 0; i< acciones.length; i++)
		{
			if(acciones[i]!=null && !this.tiene(acciones[i]))
			{
				this.acciones[numhabi] = acciones[i];
				this.numhabi++;
			}
			
		}
		
	}
	//visualizadores
	public void visualizarBasico() {
		System.out.println("---------------Objeto--------------");
		System.out.println("Nombre: " + nombre );
		System.out.println("Valor: "+ valor);
		
		
	}
	
	public void visualizar()
	{
		System.out.println("---------------Objeto--------------");
		System.out.println("Nombre: " + nombre );
		
		System.out.println("Valor: "+ valor);
	
		for (int i = 0; i< this.acciones.length; i++)
		{
			if(acciones[i]!=null)
			{
				System.out.println();
				System.out.println("Accion " + (i+1));
				acciones[i].visualizar();
			}
		}
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	
//constructor tiene de habiliades hace una busque da para ver si no esta vacio y la habilidad que le pasamos 
	//esta en acciones 
	
	public boolean tiene(Habilidad habilidad)
	{
		
		boolean salida = false;
		for(int i=0; i<this.acciones.length; i++)
		{
			if(this.acciones[i]!=null && this.acciones[i].esIgual(habilidad))
				salida=true;
		}
		return salida;
	}
	
	//añadir habilidades de la clase items
	public boolean addHabilidad(Habilidad habilidad) 
	{
		//declaracion de variables locales
		boolean salida = false;
		boolean encontrado = false;
		
		//si la ha encontrado las habilidades la pasa a encontrado
		encontrado=tiene(habilidad);
		
		//comprueba que se puede introducir una nueva habilidad en acciones
		//sino la encuentra --no esta repetido
		if(!encontrado)
		{
			if(numhabi !=acciones.length) {
				acciones[numhabi]=habilidad;//guarda la habilidad en la array en la posicion de habilidades
				numhabi++;//tenemos una nueva habilidad
				salida = true;
			}
	
		}
		
		return salida;
	}
	
	
	public boolean eliminarHabilidad(Habilidad habilidad) {
		//declaraciones locales
		boolean salida=false;
		boolean encontrado = false;
		int pos=0;
		//comprobamos si exite la habilidad y la sacamos
		for(int i=0; i<this.acciones.length; i++)
		{
			if(this.acciones[i]!=null && this.acciones[i].esIgual(habilidad)) {//si no son nulas y son iguales al que pasamos
				pos=i;//guardamos la posicion
				encontrado=true;//la encontramos
			}
		}
		//vacimos esa posicion
		//si lo encuentra 
		if(encontrado) {
			acciones[pos]=null;//combierte la posicion en nullo 
			for(int i=pos;i<numhabi-1;i++) {
				acciones[i]=acciones[i+1];//mueve la posicion siguientes a la que acabamos de borrar
			}
			
			acciones[numhabi-1]=null;//dejamos a nullo la ultima posicion
			numhabi--;//tenemos una habilidad menos
			salida = true;
		}
		
		
		return salida;
	}
	
	//comparadores
	 public boolean esIgual(Item items)
	   
			{
				boolean salida = true;
				if(this.nombre.equals(items.nombre))//si el nombre es igual al que le pasamos
				{
					if(this.numhabi == items.numhabi)//si el numero de habilidades que le locales del items es igual a los numeros
						//de de habilidades de los atributos globales de esta clase
					{
						//entonces recorre  el array items acciones
						for(int i = 0; i < this.numhabi; i++)
						{
							if(!tiene(items.acciones[i]))//si no la tiene 
							{
								salida =false;
							}
						}
					}else {
						salida = false;
					}
				}else {
					salida = false;
				}
				
				return salida;
					
			}
	 
	 
	 @Override
	 public boolean equals(Object item1)
	 {
		 boolean salida = true;
		 
		 Item item2 = (Item) item1;
		 
		 if(this.nombre.equals(item2.nombre))
			{
				if(this.numhabi == item2.numhabi)
				{
					for(int i = 0; i < this.numhabi; i++)
					{
						if(!tiene(item2.acciones[i]))
						{
							salida =false;
						}
					}
				}else {
					salida = false;
				}
			}else {
				salida = false;
			}
		 
		 
		 return salida;
	 }
	  
	  
	  
	  
}