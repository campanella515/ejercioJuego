package juego;



public class Zona {
	private String nombre;
	private int nivel=0;
	private Personaje[] npcs;
	
	private int numper;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public Personaje[] getNpcs() {
		return npcs;
	}
	public void setNpcs(Personaje[] npcs) {
		this.npcs = npcs;
	}
	public Zona()
	{
	nombre="desierto";
	nivel=100;
	npcs=new Personaje[10];
	numper=0;
	
	
	for(int i=0;i<npcs.length;i++)
	{
		if(npcs[i] != null)
		{
			npcs[i] = new Personaje();
			numper++;
		}
		
	}
		
	

	}
	public Zona(Zona zona) 
	{
		this.nombre=zona.nombre;
		this.nivel=zona.nivel;
		this.numper=zona.numper;
		
		
		for(int i=0;i<npcs.length;i++)
		this.npcs[i]=zona.npcs[i];
	}
	public Zona(String nombre,int nivel,Personaje[] npcs)
	{
		this.nombre=nombre;
		this.nivel=nivel;
		this.npcs = new Personaje[10];
		
		for(int i=0;i<npcs.length;i++)
		{
		if(npcs[i]!=null && !this.tiene(npcs[i]))
			{
				this.npcs[numper] = npcs[i];
				this.numper++;
			}
			
		}
		
	}
	
	public boolean tiene(Personaje per)
	{
		
		boolean salida = false;
		for(int i=0; i<this.npcs.length; i++)
		{
			if(this.npcs[i]!=null && this.npcs[i].esIgual(per))
				salida=true;
		}
		return salida;
	}
	
	public void visualizarBasico() {
		System.out.println("el nombre es :"+nombre);
		System.out.println("el nivel es :"+nivel);
	}
	
	public void visualizar(){
		System.out.println("el nombre es :"+nombre);
		System.out.println("el nivel es :"+nivel);
		
		for(int i=0;i<this.npcs.length;i++)
		{
			if(this.npcs[i]!=null)
				System.out.println("el npcs es "+i);
		}
			
		
		
	}
	public boolean esIgual(Zona zona)
	{
		boolean salir=false;
		if(this.nombre.equals(zona.getNombre())&&this.nivel==zona.getNivel()&&npcsIgual(zona))
		{
			salir=true;
		}
		return salir;
	}
	
	public boolean npcsIgual(Zona zona) 
	{
		boolean igual=false;
		for(int i=0;i<zona.npcs.length;i++) {
			if(this.npcs.equals(zona.npcs)) {
				igual=true;
			}
			
	  }
		return igual;
	}
	
	
	public int addPersonaje(Personaje per) 
	{
		
		int salida = 0;
		boolean encontrado = false;
		
		
		encontrado=tiene(per);
		
		if(!encontrado)
		{
			if(numper !=npcs.length) {
				npcs[numper]=per;
				numper++;
				salida = 1;
			}
	
		}
		
		return salida;
	}
	public int eliminarPersonaje(Personaje per) {
		int salida=0;
		boolean encontrado = false;
		int pos=0;
		//comprobamos si exite la habilidad y la sacamos
		for(int i=0; i<this.npcs.length; i++)
		{
			if(this.npcs[i]!=null && this.npcs[i].esIgual(per)) {
				pos=i;
				encontrado=true;
			}
		}
		//vacimos esa posicion
		if(encontrado) {
			npcs[pos]=null;
			for(int i=pos;i<numper-1;i++) {
				npcs[i]=npcs[i+1];
			}
			
			npcs[numper-1]=null;
			numper--;
			salida = 1;
		}
		
		
		return salida;
	}
}

