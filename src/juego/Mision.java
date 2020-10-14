package juego;
public class Mision {
	private String nombre;
	private int monedas;
	private int nivel;
	
	private Personaje objetivo;//falla
	private Zona zona;
	
	private Item recompensa;
	
	int numreco;
	
	//get and set
	
	
	

	public String getNombre() {
		return nombre;
	}
	public Personaje getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(Personaje objetivo) {
		this.objetivo = objetivo;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public Item getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(Item recompensa) {
		this.recompensa = recompensa;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public Mision(){
		 nombre="fuga";
	       
		 
		 
		 monedas=100;
		 nivel=5;
		
	}
	
	public Mision(Mision mision)
	{
		this.monedas=mision.monedas;
		this.nivel=mision.nivel;
		this.nombre=mision.nombre;
		this.zona=mision.zona;
		this.recompensa=mision.recompensa;
		this.monedas=mision.monedas;
		
	
		 
		
	}
	
	public Mision(String nombre,int nivel, Personaje objetivo,Zona zona,Item recompensa,int monedas)
	{
		this.nombre=nombre;
		this.monedas=monedas;
		this.objetivo=objetivo;
		this.nivel=nivel;
		this.zona=zona;
		this.recompensa=recompensa;
		
		
		
	}
	
	public void visualizarBasico() {
		System.out.println("el nombre es:"+nombre);
		System.out.println("las monedas: "+monedas);
	}
	
	public void visualizar() 
	{
		System.out.println("el nombre es:"+nombre);
		System.out.println("las monedas: "+monedas);
		if(objetivo != null)
		{
			System.out.println("el objto:");
			objetivo.visualizar();
		}
		
		if(recompensa != null)
		{
			System.out.println("el recompnea:");
			recompensa.visualizar();
		}
		
		if(zona != null)
		{
			System.out.println("el zona:");
			zona.visualizar();
		}
		
		System.out.println("el nivel "+nivel);
		
		
	}
	public boolean esIgual(Mision mision) {
		boolean salir=false;
				if(this.nombre.equals(mision.getNombre())&&this.monedas==mision.getMonedas()&&this.nivel==mision.getNivel()
						&&this.zona==mision.getZona()&&this.objetivo==mision.getObjetivo()) {
					salir=true;
				}
				return salir;
	}
	
	
	

}
