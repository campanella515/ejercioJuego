package juego;



public class Habilidad {
	//declaraciones globales
	
		private String nombre;
		private int vida;
		private int energia;
		private String tipo;
		
		//get and set
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getVida() {
			return vida;
		}
		public void setVida(int vida) {
			this.vida = vida;
		}
		public int getEnergia() {
			return energia;
		}
		public void setEnergia(int energia) {
			this.energia = energia;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		//constructores p
		
		public Habilidad(){
			nombre="saltar";
			vida=100;
			energia=100;
			tipo="fisica";
		}
		
		public Habilidad(Habilidad habilidad){
			this.nombre=habilidad.nombre;
			this.energia=habilidad.energia;
			this.tipo=habilidad.tipo;
			this.vida=habilidad.vida;
		}
		
		public Habilidad(String nombre,int vida,int energia,String tipo){
			this.nombre=nombre;
			this.tipo=tipo;
			this.vida=vida;
			this.energia=energia;
		}
		//toString que devuelvelve en forma de cadena los objetos habilidades
		 @Override
		    public String toString() {
			 
			 String cad = "";
			 
			cad = this.nombre+";"+this.vida+";"+this.energia+";"+this.tipo;
			 
			 return cad;
		       
		    }
		//visualizadores
	    public void visualizar(){
	    	
	    	System.out.println("-------habilidades---------");
			System.out.println("el nombre es:"+nombre);
			System.out.println("El tipo es :"+tipo);
			System.out.println("la vida es: "+vida);
			System.out.println("La energia es : "+energia);
		}
        public void visualizarBasico(){
	    	
	    	System.out.println("-------habilidades---------");
			System.out.println("el nombre es:"+nombre);
			System.out.println("El tipo es :"+tipo);
			System.out.println("la vida es: "+vida);
			System.out.println("La energia es : "+energia);
		}
	    
	//comparadores 
	    boolean esIgual(Habilidad habilidades)
	   
		{//mediante el equal compara si los nombres son igual
			boolean salida = false;
			if(this.nombre.equals(habilidades.nombre))
				salida = true;
			return salida;
				
		}
	    
	    
	
		
	

}
