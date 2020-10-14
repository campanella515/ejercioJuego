package juego;

public class Personaje {
	
	private String clase;
	private int vida_max;
	private int vida_actual;
	private int energia_actual;
	private int monedas;
	private boolean npc;
	private boolean hostil;
	private int energia_max;
	
	private Habilidad[] habilidades = new Habilidad[5];
	private Item[] equipo = new Item[10];
	int numequipo;
	int numhabi;
	
	private String nombre;
	
	
	
	
	
	


	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getVida_max() {
		return vida_max;
	}

	public int getEnergia_max() {
		return energia_max;
	}

	public void setEnergia_max(int energia_max) {
		this.energia_max = energia_max;
	}

	public void setVida_max(int vida_max) {
		this.vida_max = vida_max;
	}

	public int getVida_actual() {
		return vida_actual;
	}

	public void setVida_actual(int vida_actual) {
		this.vida_actual = vida_actual;
	}

	public int getEnergia_actual() {
		return energia_actual;
	}

	public void setEnergia_actual(int energia_actual) {
		this.energia_actual = energia_actual;
	}

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public boolean isNpc() {
		return npc;
	}

	public void setNpc(boolean npc) {
		this.npc = npc;
	}

	public boolean isHostil() {
		return hostil;
	}

	public void setHostil(boolean hostil) {
		this.hostil = hostil;
	}

	public Habilidad[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidad[] habilidades) {
		this.habilidades = habilidades;
	}

	public Item[] getEquipo() {
		return equipo;
	}

	public void setEquipo(Item[] equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Personaje()
	{
		 clase="guerrero";
		 vida_max=100;
		 vida_actual=100;
		 energia_actual=100;
		 energia_max=100;
		 monedas=0;
		 npc=true;
		 hostil=true;		
		 habilidades=new Habilidad[10];
		 equipo=new Item[10];	
		 nombre="partisium";

			for(int i=0;i<habilidades.length;i++)
				habilidades[i] = new Habilidad();
			
			
			
	
			
		
	}
	
	public Personaje(Personaje per)
	{
		
		 this.clase=per.clase;
		 this.vida_max=per.vida_max;
		 this.vida_actual=per.vida_actual;
		 this.energia_max=per.energia_max;
		 this.energia_actual=per.energia_actual;
		 this.monedas=per.monedas;
		 this.npc=per.npc;
		 this.hostil=per.hostil;
		 this.nombre=per.nombre;
		 this.equipo=new Item[10];		
		 this.habilidades=new Habilidad[5];
			
		 for(int i=0;i<habilidades.length;i++) 
		 {
			 
			this.habilidades[i] =per.habilidades[i];
		 }
		 
		 for(int i=0;i<equipo.length;i++) {
			 
			 this.equipo[i]=per.equipo[i];
		 }
		
	}
	public Personaje(String nombre,String clase,int vida_max,int vida_actual,int energia_actual,int energia_max,int monedas,Habilidad[] habilidades, Item[] equipo,boolean npc,boolean hostil)
	{
		this.nombre=nombre;
		this.clase=clase;
		this.vida_max=vida_max;
		this.equipo =equipo;
		this.vida_actual=vida_actual;
		this.energia_max=energia_max;
		this.energia_actual=energia_actual;
		this.monedas=monedas;
		this.npc=npc;
		this.hostil=hostil;
				
		
		
		for (int i = 0; i< habilidades.length; i++)
		{
			if(habilidades[i]!=null)
			{
				this.habilidades[numhabi] = habilidades[i];
				this.numhabi++;
			}
			
		}
		
		for(int i=0;i<equipo.length;i++) {
			if(equipo[i]!=null)
			{
				this.equipo[numequipo] = equipo[i];
				this.numequipo++;
				
			}
		}
		
	}
	 @Override
	 public String toString() {
		 
		 String cad = "";
		 String cad1="";
		 //nombre,clase,vida_max,vida_actual,energia_actual,monedas,energia_max,auxhabs,
			//auxitem,npc,hostil
		 cad = this.nombre+";"+this.clase+";"+this.vida_max+";"+this.energia_max+";"+this.vida_actual+";"+this.energia_actual+";"+this.monedas+";"+this.npc+";"+this.hostil+";";
		 System.out.println(cad);
		 for(int i=0;i<numhabi;i++) {
			
		 cad1+=this.habilidades[i].getNombre();
		 if(i<numhabi-1) {
			 cad1+=",";
		   }//this.energia_max+";"
		 }
		 return cad+cad1;
    }

	public void visualizarBasico() {
		System.out.println("el nombre "+nombre);
		
		System.out.println("la clase es:"+clase);
		System.out.println("la vida maxima es:"+vida_max);
		System.out.println("la vida actual es "+vida_actual);
		System.out.println("la energia actual es:"+energia_actual);
		System.out.println("las moneda que tiene son:"+monedas);
		System.out.println("quiere npc:"+npc);
		System.out.println("quiere que sea hostil:"+hostil);
		/**
		 * private String clase;
	private int vida_max;
	private int vida_actual;
	private int energia_actual;
	private int monedas;
	private boolean npc;
	private boolean hostil;
	private int energia_max;*/
		
	}	
    
	public void visualizar() 
	{
		System.out.println("la clase es:"+clase);
		System.out.println("la vida maxima es:"+vida_max);
		System.out.println("la vida actual es "+vida_actual);
		System.out.println("la energia actual es:"+energia_actual);
		System.out.println("las moneda que tiene son:"+monedas);
		System.out.println("quiere npc:"+npc);
		System.out.println("quiere que sea hostil:"+hostil);
		
		System.out.println("el nombre es:"+nombre);
		
		for(int i=0;i<habilidades.length;i++)
			if(habilidades!=null)
			System.out.println("habilidades es "+i);
		
		for(int i=0;i<equipo.length;i++)
			if(equipo!=null)
			System.out.println("el equipo es "+i);

				
	}
	public boolean esIgual(Personaje per)
	{
		boolean salida=false;
		
		if(this.nombre.equals(per.nombre))
		{
			salida=true;
		}
		return salida;
	}
	
	public int eliminarHabilidad(Habilidad habilidades)	{
		
		int salida=0;
		boolean encontrado=false;
		int pos=0;
		
		for (int i=0;i<numhabi;i++) {
			if(this.habilidades[i]!=null && this.habilidades[i].esIgual(habilidades)) {
				pos=i;
				encontrado=true;
				
			}
		}
		//vaciamos la porsicion
		if (encontrado) {
			this.habilidades[pos]=null;
			for(int i=pos;i<numhabi-1;i++) {
				this.habilidades[i]=this.habilidades[i+1];
			}
			this.habilidades[numhabi-1]=null;
			numhabi--;
			salida = 1;
		}
		return salida;
	}
		
		
	
	
	public boolean habilidadIgual(Personaje per) {
		boolean igual=false;
		for(int i=0;i<per.habilidades.length;i++) {
			if(this.habilidades.equals(per.habilidades)) {
				igual=true;
			}
			
			
		}
		return igual;
	}
	
	public boolean equipoIgual(Personaje per) {
		boolean igual=false;
		for(int i=0;i<per.equipo.length;i++) {
			if(this.equipo.equals(per.equipo)) {
				igual=true;
			}
		}
		return igual;
	}
	
	public int addHabilidad(Habilidad habilidades) 
	{
		
		int salida = 0;
		boolean encontrado = false;
		
		for(int i=0;i<numhabi;i++) {
			if(this.habilidades[i].esIgual(habilidades) && this.habilidades[i]!=null) {
		           
		           encontrado=true;
			}
		}
		
		//comprueba que se puede introducir una nueva habilidad en acciones
		if(!encontrado)
		{
			if(numhabi !=this.habilidades.length) {
				this.habilidades[numhabi]=habilidades;
				numhabi++;
				salida = 1;
			}
	
		}
		
		return salida;
	}
	
	public int addItem(Item equipo) 
	{
		
		int salida = 0;
		boolean encontrado = false;
		
		
		encontrado=tiene(equipo);
		
		//comprueba que se puede introducir una nueva habilidad en acciones
		if(!encontrado)
		{
			if(numequipo !=this.equipo.length) {
				this.equipo[numequipo]=equipo;
				numequipo++;
				salida = 1;
			}
	
		}
		
		return salida;
	}
	public int eliminarItem(Item item) {
		int salida=0;
		boolean encontrado = false;
		int pos=0;
		//comprobamos si exite la habilidad y la sacamos
		for(int i=0; i<this.equipo.length; i++)
		{
			if(this.equipo[i]!=null && this.equipo[i].esIgual(item)) {
				pos=i;
				encontrado=true;
			}
		}
		//vacimos esa posicion
		if(encontrado) {
			equipo[pos]=null;
			for(int i=pos;i<numequipo-1;i++) {
				equipo[i]=equipo[i+1];
			}
			
			equipo[numequipo-1]=null;
			numequipo--;
			salida = 1;
		}
		
		
		return salida;
	}
	
	public boolean tiene(Item item)
	{
		
		boolean salida = false;
		for(int i=0; i<this.equipo.length; i++)
		{
			if(this.equipo[i]!=null && this.equipo[i].esIgual(item))
				salida=true;
		}
		return salida;
	}
	public boolean tiene(Habilidad habilidad)
	{
		
		boolean salida = false;
		for(int i=0; i<this.habilidades.length; i++)
		{
			if(this.habilidades[i]!=null && this.habilidades[i].esIgual(habilidad))
				salida=true;
		}
		return salida;
	}
	
	
}
