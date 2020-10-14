package juego;

import java.util.*;



import com.mysql.jdbc.Statement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;


public class Gestor {
	
	//array y arraylist declaraciones
	public ArrayList<Habilidad> habilidades;
	public ArrayList<Item> items;
	public ArrayList<Personaje> personajes ;
	public Mision[] misiones;
	public Usuario[] users;
	public Zona[] zonas;
	
	
	
	//atributos
	private int numhab;//numero habilidades en nuestro array de habilidades
	private int numitem; // numero de items en nuestro array de items
	private int numzonas;
	private int numper;
	private int num_mis;
	private int num_users;
	private int num_hab_item;
	
	private Scanner teclado = new Scanner(System.in);
	
	
	
	
	
	
	 private String valor;
	//get and sets
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	//metodo gestor donde declaramos la arrays de tamaño 50
	//constructor por defecto
	public Gestor()
	{
		habilidades = new ArrayList<Habilidad>();
		items = new ArrayList<Item>();		
		personajes= new ArrayList<Personaje>();
		
		numhab=0;
		numitem=0;
		numper=0;
		numzonas=0;
		num_mis=0;
		num_users=0;
		num_hab_item=0;
		
		misiones=new Mision[50];
		users=new Usuario[50];
		zonas=new Zona[50];
	}
	
	
	/*
	public void inicializarPruebas()
	{
		//////////////////////
		//Inicializacion de pruebas:
		/////////////////////
		
		
		for(int i = 0; i<10;i++)
		{
			habilidades[i]= new Habilidad("hab"+i,i,i,"tipo"+i);
		}
		numhab=10;
		Habilidad habiaux[] = new Habilidad[10];
		items[0]=new Item("objeto 0",0,"tipo 0", 0, 0, 0, habiaux);
		items[1]=new Item("objeto 1",0,"tipo 0", 0, 0, 0, habiaux);
		items[2]=new Item("objeto 2",0,"tipo 0", 0, 0, 0, habiaux);
		habiaux[0] = habilidades[3];
		items[3]=new Item("objeto 3",0,"tipo 0", 0, 0, 0, habiaux);
		numitem = 4;
	}
	*/
	
	
	
	public void menu()
	{
		int opcion;
		System.out.println("Bienvenido al gestor del videojuego: \"Todos suspensos\"");
		do {
			System.out.println("Selecciona la opcion deseada");
			System.out.println("Opcion 1: Añadir habilidad");
			System.out.println("Opcion 2: Mostrar habilidades");
			System.out.println("Opcion 3: Añadir objetos");
			System.out.println("Opcion 4: Mostrar obejetos");
			System.out.println("Opcion 5: Añadir mision");
			System.out.println("Opcion 6: Mostrar misiones");
			System.out.println("Opcion 7: Añadir zona");
			System.out.println("Opcion 8: Mostrar zona");
			System.out.println("Opcion 9: Añadir Personaje");
			System.out.println("Opcion 10: Mostrar Personaje");
			System.out.println("Opcion 11: Eliminar item");
			System.out.println("Opcion 12: Eliminar misiones");
			System.out.println("Opcion 13: Eliminar habilidades");
			System.out.println("Opcion 14: Eliminar zona");
			System.out.println("Opcion 15: eliminar personaje");
			System.out.println("Opcion 16: modificar habilidad personaje");
			System.out.println("Opcion 17: borrar habilidad item");
			System.out.println("Opcion 18: Leer ficheros txt");
			System.out.println("Opcion 19: asignar habilidad item");
			System.out.println("Opcion 20: guardar fichero");
			System.out.println("Opcion 21:guardar habilidades en base de datos");
			System.out.println("Opcion 22:guardar personajes en base de datos");
			System.out.println("Opcion 23:Leer Datos Personaje");
			System.out.println("Opcion 24:Leer Datos Habilidades");
			System.out.println("Opcion 0: Salir");
			
			opcion= teclado.nextInt();
			teclado.nextLine();
			
			switch (opcion)
			{
				case 1:
					anyadirHabilidad();
					break;
				case 2:
					mostrarHabilidades();
					break;
				case 3:
					anyadirItem();
					break;
				case 4:
					mostrarItems();
					break;
				case 5:
					anyadirMision();
					break;
				case 6:
					mostrarMisiones();
					break;
				case 7:
					anyadirZona();
					break;
				case 8:
					mostrarZona();
					break;
				case 9:
					anyadirPersonaje();
					break;
				case 10:
					mostrarPersonajes();
					break;
				case 11:
					eliminarItem();
					break;
				case 12:
					eliminarMision();
					break;
				case 13:
					eliminarHabilidad();
					break;
				case 14:
					eliminarZona();
					break;
				case 15:
					 eliminarPersonaje();
					break;
				case 16:
					 modHabPer();
					break;
				case 17:
					eliminarHabItem() ;
					break;
				case 18:
					leerDeFichero();
					break;
				case 19:
					 asigHabItem();
					break;
				case 20:guardarEnFichero();
					break;
				case 21:guardarDatosHabilidades();
					break;
				case 22:guardarDatosPersonajes();
				break;
				case 23:LeerDatosPersonaje();
				break;
				case 24:LeerDatosHabilidades();
				break;
				
				case 0:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("No es una opcion admitida");
					break;
			}
		}while(opcion!=0);
	}
	//añadir habilidad
	public boolean anyadirHabilidad()
	{
		//variables locales
		boolean salida=false;
		//solicito datos por teclados
		
		System.out.println("Introduce el nombre");
		String nombre = teclado.next();
		System.out.println("Introduce la vida");
		int vida = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce la energia");
		int energia = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el tipo");
		String tipo = teclado.nextLine();
		//creo objetos aux y le paso la entrados por teclado
		Habilidad aux = new Habilidad(nombre, vida, energia, tipo);
		//habilidades.add(aux);
		
		
		if(habilidades.indexOf(aux) == -1)//al ser un idexof si devuelve -1 si no lo encuentra(hace un for interno)
		{
			if(habilidades.size() <50 )//es menor que 50 que son los valor maximo
			{
				numhab=habilidades.size();
				habilidades.add(aux);//añadimos
				numhab++;//hay una habilidad mas
				salida =true;//salida devuelve un true
			}
			else
			{
				System.out.println("El array esta lleno");
			}
		}
		else
		{
			System.out.println("Error ya existe");
		}
		
		return salida;
	}
	//-----------añadirHabilidad------------
	
	public boolean anyadirHabilidad(Habilidad habilidad) //habilidad es un arraylist
	{
			boolean salida = false;
			//si no lo entruentra mediante un idexof que lo añada
			if(habilidades.indexOf(habilidad) == -1){
				salida = habilidades.add(habilidad);
			}else
				System.out.println("La habilidad ya existe");
			
			return salida;
	}
		
	
	
	//---------añadir Item-----------------
	
	
	public boolean anyadirItem()
	{
		boolean salida = false;
		
		//solicitamos por teclado que objeto quiere añadir y llamos a los metodos 
		//los cuales retornan booleanos , los manda ha salida que es quien retorna en este metodo
		int numero=0;
		System.out.println("Que item va a introducir");
		System.out.println("1:armadura");
		System.out.println("2:arma");
		System.out.println("3:consumible");
		numero=teclado.nextInt();
		teclado.hasNextLine();
		switch(numero) {
		  case 1:
			salida=this.anyadirArmadura();
		    break;
		  case 2:
		   salida=this.anyadirArma();
			  
		    break;
		  case 3:
		   salida=this.anyadirConsumible();
			    break;
		  default:
			  System.out.println("no es una opcion valida");
		   
		}
		return salida;
	
		
	}
	
	//---añadir Item item por parametros
	public boolean anyadirItem(Item item) 
	{
		boolean salida = false;
		//nuevamente como es un arraylist la recorremos con un indexof si devuelve un -1 es que no existe
		//y procede a añadirlo a el array items mediante add
		if(items.indexOf(item) == -1){
			salida = items.add(item);
		}else
			System.out.println("Ya existe el item");
		
		return salida;
		
	}
	//---añadir consumible-------------
	
	private boolean anyadirConsumible() {
		 boolean salida=false;
		 //solicito por teclado
			System.out.println("Introduce del nombre del consumible");
			String nombre = teclado.nextLine();
			
			System.out.println("Introduce el valor del consumible");
			int valor = teclado.nextInt();
			teclado.nextLine();	
			
			System.out.println("Introduce la cantidad de los consumibles");
			int cantidad = teclado.nextInt();
			teclado.nextLine();
			
		//creamos un array accion de tipo habilidad de tamaño 5
			Habilidad acciones[]=new Habilidad[5];
			int numhabenitem=0; //numero de habilidades que se han a�adido al item
			
			int nhab;
			//mostrare la habilidades y le asigno su valor por posicion
			do {
				System.out.println("Elige la habilidad a introducir");
				for(int i = 0; i<habilidades.size();i++)
				{
					System.out.println("Habilidaes"+i);
					habilidades.get(i).getNombre();//muestra la habilidades en concreto el campo nombre
				}
				//solicitamos un numero (resulta mas sencillo por numero de posicion que por nombre)
				System.out.println("Introduce el numero de la habilidad, \"\" para no anyadir ninguna");
				nhab = teclado.nextInt();
				teclado.nextLine();
				if(nhab < habilidades.size())//si hay hay sitio en habilidades
				{
					
				//	habilidad.setNombre(nombrehab);
					int posHab = habilidades.indexOf(habilidades.get(nhab));//guarda en posicion habilidad 
						if(posHab > -1) {//si np lo encentra , hay sitio
							acciones[numhabenitem]=habilidades.get(posHab);//guarda lo que hay en la posicion habilidade
							//en el array accion en la posicion de numero de habilidad de item
							numhabenitem++;//hay otra habilidad en el item
							//¿salida=true;
						
					}
					else 
					{
						System.out.println("error ya existe");
					}
					
				}
				
			}while(numhabenitem<5);//hace la solicitud siempre que el numero de habilidades en items sea menor que
			//5 que es el tamaño maxim
			//creamos un objeto aux de tipo consumiteble le pasomos los parametros por teclado según el 
			//orden que tienen en el metodo sobre cargado de la clase consumible
	
		//	String nombre,int valor,Habilidad[] acciones,int cantidad
			Consumible aux = new Consumible(nombre,valor,acciones,cantidad);
			
			salida = anyadirItem(aux);//mandamos al metodo añadir item
			
			
			return salida;
		
	}
	
	
	//--añadir item arma---------------
	
     private boolean anyadirArma() {
    	 
	 boolean salida=false;
	 //solicitamos por teclado
		System.out.println("Introduce del nombre del arma");
		String nombre = teclado.nextLine();
		
		System.out.println("Introduce el valor del arma");
		int valor = teclado.nextInt();
		teclado.nextLine();	
		System.out.println("Introduce el daño del arma");
		int agravio = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el peso de del arma");
		int peso = teclado.nextInt();
		teclado.nextLine();
		
	    //asignar habilidades a el array item
		Habilidad acciones[]=new Habilidad[5];
		int numhabenitem=0; //numero de habilidades que se han a�adido al item
		
		int nhab;
		
			do {
				System.out.println("Elige la habilidad a introducir");
					for(int i = 0; i<habilidades.size();i++)
					{
						System.out.println("Habilidaes"+i);
						habilidades.get(i).getNombre();
					}
				System.out.println("Introduce el numero de la habilidad, \"\" para no anyadir ninguna");
				nhab = teclado.nextInt();
				teclado.nextLine();
					if(nhab < habilidades.size())//si el nombre de las habilidades no son iguales
					{
						
					//	habilidad.setNombre(nombrehab);
						int posHab = habilidades.indexOf(habilidades.get(nhab));
						if(posHab > -1) {
							acciones[numhabenitem]=habilidades.get(posHab);
							numhabenitem++;
						}else {
							System.out.println("error ya existe");
						}
							
					}
				
			}while(numhabenitem<5);
	//	String nombre,int valor,Habilidad[] acciones,int agravio,int peso
		
		Arma aux = new Arma(nombre,valor,acciones,agravio,peso);
		
		salida = anyadirItem(aux);//mandamos el objetos que generamo al metodo añadir item
		
		
		
		
		return salida;
	
}	
	//---añadir armadura--
 private boolean anyadirArmadura() {
	 boolean salida=false;
	System.out.println("Introduce del nombre");
	String nombre = teclado.nextLine();
	teclado.nextLine();
	
	System.out.println("Introduce el valor");
	int valor = teclado.nextInt();
	teclado.nextLine();	
	
	System.out.println("Introduce el daño a la armadura");
	int armadura = teclado.nextInt();
	teclado.nextLine();
	
	System.out.println("Introduce el peso de la armadura");
	int peso = teclado.nextInt();
	teclado.nextLine();
	
    //asignar habilidades a el array item
	Habilidad acciones[]=new Habilidad[5];
	int numhabenitem=0; //numero de habilidades que se han a�adido al item
	
	int nhab=-1;
	
	do {
		System.out.println("Elige la habilidad a introducir");
		for(int i = 0; i<habilidades.size();i++)
		{
			System.out.println("Habilidaes"+i);
			habilidades.get(i).getNombre();
		}
		if(numhabenitem > 5) {
			System.out.println("no puede tener mas habilidades ");
		}else {
			System.out.println("Introduce el numero de la habilidad, \"\" para no anyadir ninguna");
			nhab = teclado.nextInt();
			teclado.nextLine();
			
			if(nhab < habilidades.size() && nhab >= 0 )//si el nombre de las habilidades no son iguales
			{
				
			//	habilidad.setNombre(nombrehab);
				int posHab = habilidades.indexOf(habilidades.get(nhab));
				for(int i=0;i<acciones.length;i++) {
					if(acciones[i]!=null && posHab > -1) {
						acciones[i]=habilidades.get(posHab);
						numhabenitem++;
						
					}else {
						System.out.println("error ya existe");
					}
					
				}
			}
			
		}
		
	}while( nhab != -1 );
	
	Armadura aux = new Armadura(nombre,valor,acciones,armadura,peso);
	
	salida = anyadirItem(aux);
	
	return salida;
}
	
	// -----añadir zona-----------------
	//añadimos zona
	public boolean anyadirZona()
        {
		boolean salida = false;
		//solicitamos por teclado
		System.out.println("Introduce del nombre");
		String nombre = teclado.nextLine();
		System.out.println("Introduce el nivel");
		int nivel = teclado.nextInt();
		teclado.nextLine();
		
	
		Personaje npcs[]=new Personaje[10];//cremaos un objeto tipo array Personaje, npc(robots)
		
		int numperZona=0; //numero de personas por zona
		
		String res = "";
		do {
			System.out.println("quieres añadir npcs escribe \"si\", \"\" para no añadir ninguna enter");
			res = teclado.nextLine();
			if(res.equals("si"))
			{
				System.out.println("Elige un personaje");
				for(int i = 0; i<personajes.size();i++)
				{
					System.out.println("personajes "+i);//muestra personajes numerados
					
					System.out.println(personajes.get(i).getNombre());//nos devuelve los nombres
				}
				System.out.println("Introduce el numero del personaje");
				int pos = teclado.nextInt();
				teclado.nextLine();//introducimos el numero de su posicion
				if(pos < personajes.size() && pos >= 0)
				{
					npcs[numperZona]=npcs[pos];
					numperZona++;//tenemos un personaje en zona mas
				}
			}
			
			
		}while(numperZona<5 &&  !res.equals(""));//hacer mientras haya sition y no se tabule
		
		Zona aux = new Zona(nombre,nivel,npcs);
		
		//ahora añadimos los npc(personajes) ha zona 
		boolean encontrado = false;
		//hay que hacer una busque da para ver si esta ya el objetos quue le vamos a pasar
		for(int i=0;i<50;i++)
		{
			if(zonas[i]!=null && zonas[i].esIgual(aux))//si estan llenos o iguales
			{
				encontrado =true;//ya  los hemos encontrado
				i=50;//camp
			}
		}
		//sino lo encuetra lo añadimos
		if(!encontrado)
		{
			
			if(numzonas<50)
			{
				zonas[numzonas]=aux;
				numzonas++;
				salida =true;
				
			}
			else
			{
				System.out.println("El array esta lleno");
			}
		}
		else
		{
			System.out.println("Error ya existe");
		}
		
		
		
		return salida;
		
		}
	
	
	//----añadire Zona zona ------------------
	public boolean anyadirZona(Zona zona) //por parametros nos ahorramos el introducir por teclado
	{
		boolean salida = false;
		
		boolean encontrado = false;
	//hacemos una busqueda para ver si esta lleno o repetido
		for(int i=0;i<50;i++)
		{
			if(zonas[i]!=null && zonas[i].esIgual(zona))
			{
				encontrado =true;
				i=50;
			}
		}
		//si no es asi lo agrega	
		if(!encontrado)
		{
			zonas[numzonas]=zona;
			numzonas++;
			salida =true;
		}
		
		return salida;
		
	}
	
//---añadir personajes-----------
	public boolean anyadirPersonaje()
    {
		boolean salida = false;
	    boolean	encontrado=false;
 
 		boolean npc=false;
 		boolean hostil=false;
	//solicitamos por teclado
	System.out.println("Introduce del nombre");
	String nombre = teclado.nextLine();
	
	System.out.println("Introduce la clase");
	String clase = teclado.nextLine();
	
	System.out.println("Introduce la vida maxima");
		int vida_max = teclado.nextInt();
		teclado.nextLine();
	
	System.out.println("Introduce la vida actual");
		int vida_actual = teclado.nextInt();
		teclado.nextLine();
		
	System.out.println("Introduce la energia maxima");
		int energia_max = teclado.nextInt();
		teclado.nextLine();
	
	System.out.println("Introduce la energia actual");
		int energia_actual = teclado.nextInt();
		teclado.nextLine();
		
	System.out.println("Introduce las monedas");
		int monedas = teclado.nextInt();
		teclado.nextLine();
		
	
	System.out.println("hay NPC");	
	String res=teclado.nextLine();
	
	
	if(res.equals("si")) {//si el resultado es igual a "si" que se devuelva true
		
		npc=true;
		
	}
		if(npc==true)
		{//al devolcer cierto
			
		System.out.println("es hostil");
		res=teclado.nextLine();
		
		if(res.equals("si")) {//si le decimos que tambien es hostil
			
			hostil=true;
	    	}
		}
	
	
	int poshabi=-1;
	int numhabaux=0;
	Habilidad auxhabs[]=new Habilidad[5];
	//creamos una array auxiliar de habilidades de tamaño 5
	if(habilidades.size()>0) {//comprobamos si hay sitios en el array habilidades
	
		do {
		
		System.out.println("Introduce las habilidades");
		
		for(int i=0;i<habilidades.size();i++) {
		//introducir las habilidades
			System.out.println("Habilidad "+i);
			habilidades.get(i).visualizar();//nos muestra el nombre de las habilidades numeradas
			
		}
		
		poshabi=teclado.nextInt();//seleccionamos la posicion de las habilidades		
		teclado.nextLine();
		//realizamos busquedas para ver si no esta llena , si no esta repetida si no es asi la añade
		if(poshabi<=habilidades.size()&& poshabi>=0) {//si hay sitio y la posicion es distinto o igual a cero(las arrays empie
			//zan por cero)
			
			if(auxhabs.length>5) {//si el auxiliar de habilidades esta lleno
				System.out.println("No puede añadir mas abilidades a este personaje");
			}else {
				
				for(int i=0;i<auxhabs.length;i++) {
					if(auxhabs[i]!=null && auxhabs[i].esIgual(habilidades.get(poshabi))) {
					//si la habilidad no es nula o es igual 	
					System.out.println("la habilidad ya existe");
					encontrado=true;
					}
					
				}
				if(encontrado==true) {
					System.out.println("error al introducir habilidad");
				}else {
					auxhabs[numhabaux]=habilidades.get(poshabi);//agregamos la habilidad despues de hacer las comprobaciones
					numhabaux++;
				}
			}
			
			
		}else {
			System.out.println("la habilidad no existe");
		}
		}while(poshabi!=-1);
		System.out.println("");
	
	}
	
	//-----añadir equipo-------
	int numitemaux=0;
	int positem=0;
	Item auxitem[]=new Item[5];
	if(items.size()>0) {
		
		encontrado=false;
		do {
		
		System.out.println("Introduce los items");
		
		for(int i=0;i<items.size();i++) {
		//introducir las habilidades
			System.out.println("items "+i);
			items.get(i).visualizar();
			
		}
		
		
		 positem=teclado.nextInt();
		
		teclado.nextLine();
		
		if(positem<=items.size()&& positem>=0) {
			
			if(auxitem.length>5) {
				System.out.println("No puede añadir mas items a este personaje");
			}else {
				
				for(int i=0;i<auxitem.length;i++) {
					if(auxitem[i]!=null && auxitem[i].esIgual(items.get(positem))) {
						
					System.out.println("el item ya existe");
					encontrado=true;
					}
					
				}
				if(encontrado==true) {
					System.out.println("error al introducir item");
				}else {
					auxitem[numitemaux]=items.get(positem);//agregamos la habilidad despues de hacer las comprobaciones
					numitemaux++;
				}
			}
			
			
		}else {
			System.out.println("el item no existe");
		}
		}while(positem!=-1);
		System.out.println("");
		
		}
	
	Personaje aux = new Personaje(nombre, clase, vida_max, vida_actual, energia_actual,energia_max,monedas,auxhabs,
			auxitem,npc,hostil);
	
	
	if(personajes.indexOf(aux) == -1)
	{
		salida = personajes.add(aux);
	}
	

	return salida;
	
	}
	
	
	
	//añadir personaje--------
	public boolean anyadirPersonaje(Personaje personaje) 
	{
		boolean salida = false;
	//comprueba si el arraylist no encuentra nada añade	
		if(personajes.indexOf(personaje) == -1){
			salida = personajes.add(personaje);
		}
			System.out.println("El personaje ya existe");
		
		return salida;
	}
	
	
	
	
	//----añadir misiones-------
	
	public boolean anyadirMision()
	{
	boolean salida=false;
		
		System.out.println("Introduce el nombre de la mision");
		String nombre = teclado.nextLine();
		
		
		System.out.println("monedas de la mision");
		int monedas = teclado.nextInt();
		teclado.hasNextLine();
		
		System.out.println("nivel de la mision");
		int nivel = teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("Persoanejes");
		
				for(int i = 0; i < personajes.size();i++)
				{
					System.out.println("Personajes"+i);
					personajes.get(i).getNombre();
				}
				
				int nper =teclado.nextInt();
				teclado.nextLine();
				System.out.println("zonas");
				for(int i = 0; i < numzonas;i++)
				{
					System.out.println("zonas"+i);
					zonas[i].getNombre();
				}
				
				int nzona =teclado.nextInt();
				teclado.nextLine();
				System.out.println("itmes");
				for(int i = 0; i < items.size();i++)
				{
					System.out.println("Perrecompensa"+i);
					items.get(i).getNombre();
				}
				int nitem =teclado.nextInt();
				teclado.nextLine();
		
				
				
				
				
		
		
		//--------------------------------------------------------------------------------
		//String nombre,Personaje objetivo,Zona zona,Item recompensa,int monedas,int nivel
		if(nper <= personajes.size() && nzona <= numzonas && nitem <= items.size())
		{
			//nos crea un objeto auxiliar de tipo mision con los objetos personaje zonaz e item correspondientes  
			//a cada posicion
			
			Mision aux = new Mision(nombre,nivel,personajes.get(nper),zonas[nzona],items.get(nitem),monedas);
		
		//realiza la busqueda si esta lleno, si es igual o no da un fallo si los datos no existes , sino añade 
			//el objeto aux de tipo clase
			boolean encontrado = false;
			for(int i=0;i<50;i++)
			{
				if(misiones[i]!=null && misiones[i].esIgual(aux))
				{
					encontrado =true;
					i=50;
				}
			}
			
			if(!encontrado)
			{
				if(num_mis<50)
				{
					misiones[num_mis]=aux;
					num_mis++;
					salida =true;
				}
				else
				{
					System.out.println("El array est� lleno");
				}
			}
			else
			{
				System.out.println("Error ya existe");
			}
			
		}else {
			System.out.println("alguno de los datos no existe");
		}
		
		return salida;
		
		
	}
	//------añadir misiones-----
	
	public boolean anyadirMision(Mision mision)
	{
		boolean salida=false;
		
		boolean encontrado = false;
		for(int i=0;i<50;i++)
		{
			if(misiones[i]!=null && misiones[i].esIgual(mision))
			{
				encontrado =true;
				i=50;
			}
		}
		
		if(!encontrado)
		{
			if(num_mis<50)
			{
				misiones[num_mis]=mision;
				num_mis++;
				salida =true;
			}
		}
		
		return salida;
		
		
	}
	
	//-----eliminar habilidad
	public boolean eliminarHabilidad() {
		    boolean resultado=false;
			
			int pos=0;
			
			for(int i = 0; i < habilidades.size(); i++)
			{
				System.out.println("Habilidad"+i);
				System.out.println(habilidades.get(i).getNombre());
			}
			System.out.println("NUmero de habilidad a eliminar");
			
			pos = teclado.nextInt();
			teclado.nextLine();    
			   
			if(pos>=0 && pos<numhab) {
				resultado = eliminarHabilidad(habilidades.get(pos));
		
			}
			return resultado;
		}
	
	//-----eliminar habiliad habilidad
	public boolean eliminarHabilidad(Habilidad habilidad) {
		
		boolean salida = false;
			
		if(habilidades.indexOf(habilidad) > -1)
		{
			salida = habilidades.remove(habilidad);
		}else
			System.out.println("la habilidad no existe");
		
		return salida;
		
	}
	
	//----eleminar item
	//metodos de eliminar
			public boolean eliminarItem(){
				 boolean resultado=false;
					
					int pos=0;
					
					for(int i = 0; i < items.size(); i++)
					{
						System.out.println("item"+i);
						System.out.println(items.get(i).getNombre());
					}
					
					System.out.println("NUmero de item a eliminar");
					
					pos = teclado.nextInt();
					teclado.nextLine();    
					//comprobacion si la hay posicion y la posicion es menos que numero de item   
					if(pos >= 0 && pos < numitem)
						resultado = eliminarItem(items.get(pos));
				
					
					return resultado;
			}
			
	
	
	//-------------------
	
	//---eliminar Item item
			public boolean eliminarItem(Item item){
				boolean salida = false;
					
				if(items.indexOf(item) > -1)//si lo encuentra 
				{
					salida = items.remove(item);//lo borra
				}else
					System.out.println("la habilidad no existe");
				
				return salida;
				
			}
			
   //---eliminar Zona 
			public boolean eliminarZona(){
					boolean salida = false;
					
					System.out.println("zona a eliminar: ");
					
					for(int i=0; i<numzonas;i++) {
						System.out.println((i+1)+"."+zonas[i].getNombre()+".");
					}
					System.out.println("numero de la opcion: ");
					int respuesta = teclado.nextInt();
					teclado.nextLine();
					
					if(respuesta >= 1 && respuesta <= numzonas) {
						salida = eliminarZona(zonas[respuesta-1]);
					}else {
						System.out.println("La opcion no esta disponible");
					}
	
					return salida;
				}
 //---------------------
			
	//---eliminar Zona zona
	
			
		public boolean eliminarZona(Zona zonas) {
			boolean salida = false;
	//borra objeto de un array normal		
			int pos = -1;
			//busca en que posicion esta el zonas que le pasamos
			for(int i = 0; i < numzonas; i++) {
				if(this.zonas[i].esIgual(zonas)) {
					pos = i;//guarda la poscion donde la ha encontrado
				}
			}
	//si lo encontrua la poscion existe		
			if(pos != -1) {
				for(int i = pos; i < numzonas-1; i++) {
					this.zonas[i] = this.zonas[i+1];//elimina el elemento y corre una posicion
				}
				
				this.zonas[numzonas-1] = null;
				numzonas--;//hay una zona menos
				salida = true;
			}
			
			return salida;
		}
	//-----------------
//-----eleminar personajes-----------	
		public boolean eliminarPersonaje() {
			 boolean resultado=false;
				
				int pos=0;
				
				for(int i = 0; i < personajes.size(); i++)
				{
					System.out.println("personaje"+i);
					System.out.println(personajes.get(i).getNombre());
				}
				
				
				System.out.println("NUmero de personaje a eliminar");
				pos = teclado.nextInt();
				teclado.nextLine();    
				
				if(pos >= 0 && pos < numper)
					resultado = eliminarPersonaje(personajes.get(pos));
			
				
				return resultado;
			
		}
		
		
		public boolean eliminarPersonaje(Personaje personaje) {
			boolean salida = false;
				
			if(personajes.indexOf(personaje) > -1)
			{
				salida = personajes.remove(personaje);
			}else
				System.out.println("la habilidad no existe");
			
			return salida;
		}
		
		
//----elmininar misiones

		public boolean eliminarMision(){
			boolean salida = false;
			
			System.out.println("mision a eliminar: ");
			
			for(int i=0; i<num_mis;i++) {
				System.out.println((i+1)+"."+misiones[i].getNombre()+".");
			}
			System.out.println("numero de la opcion: ");
			int respuesta = teclado.nextInt();
			teclado.nextLine();
			
			if(respuesta >= 1 && respuesta <= num_mis) {
				salida = eliminarMision(misiones[respuesta-1]);
			}else {
				System.out.println("La opcion no esta disponible");
			}

			return salida;
		}
			
			
	//--eliminar Mision mision
		public boolean eliminarMision(Mision mision){
			boolean salida = false;
			
			int pos = -1;
			for(int i = 0; i < num_mis; i++) {
				if(misiones[i].esIgual(mision)) {
					pos = i;
				}
			}
			
			if(pos != -1) {
				for(int i = pos; i < num_mis-1; i++) {
					misiones[i] = misiones[i+1];
				}
				
				misiones[num_mis-1] = null;
				num_mis--;
				salida = true;
			}
			return salida;
			
		}
		
//---asignar habilidad Item----
		public boolean asigHabItem() {
			boolean salida=false;
			boolean error = false;
			int numitem=0;
			int habi=0;
		
			mostrarItems();
			System.out.println("introduce el numero de item;");
			numitem=teclado.nextInt();
			teclado.hasNextLine();
			
			if(numitem >= 0 && numitem < this.numitem) {
			//si la posion del array existe y es menor que el numero del item del atributo globa de la clase	
				mostrarHabilidades();//nos muestra las habilidade
				System.out.println("num de habilidad");
				habi=teclado.nextInt();//introducimos la posicion de la habilidad
				teclado.nextLine();
				//comprobamos que el usuario no meta una posicion incorrecta
				if(habi >= 0 && habi < numhab) {//igual que en el caso anterior sino son posiciones validas nos
					//devuelve un error 
					salida=items.get(numitem).addHabilidad(habilidades.get(habi));
				} else {
					error = true;
				}
			}else {
				error = true;
			}
			
			if(error) {//llamada ha pantalla de nuestro error
				System.out.println("Error en la entrada");
			}
			
			return salida;
		}
		
        public boolean asigHabItem(Habilidad habilidad , Item item) {
        	boolean salida=false;
        	int num_item=0;
        	
        	num_item=items.indexOf(item);
        	if(num_item>-1)
        	{//usamos el metodos añadir de la clase item
        		salida=items.get(num_item).addHabilidad(habilidad);
        	}
        	
        	return salida;
	
        }

        //------------modificar equipo----------------
        public int modEquipo() {
        	int salida=-1;
        	int numero=0;
        	
        	boolean error = false;
        	
        	System.out.println("que quieres eliminar equipo personaje 1 o añadir equipo personaje 2");
        	
        	numero=teclado.nextInt();
        	teclado.nextLine();
        	
        	switch(numero) {
        	case 1:
        		int nuper=0;
    			int nequipo=0;
    		
    			for(int i =0; i<personajes.size(); i++)
        		{
        			System.out.println(i+". "+personajes.get(i).getNombre());
        		}
    			
    			System.out.println("introduce el numero del personaje;");
    			
    			nuper=teclado.nextInt();
    			teclado.hasNextLine();
    			
    			if(nuper>=0 && nuper<numper) {
    				mostrarItems();
        			System.out.println("num de equipo");
        			
        			nequipo=teclado.nextInt();
        			teclado.nextLine();
        			
        			if(nequipo>=0 && nequipo>=numhab) {
	        			salida=this.personajes.get(nuper).eliminarHabilidad(habilidades.get(nequipo));
	        			
        			}else
        				error = true;
    			
    			}else
    				error = true;
    			
    			if(error) {
    				System.out.println("Error en la entrada");
    			}
    			
        		break;
        		
        	case 2:
        		int nuper1=0;
    			int nequipo1=0;
    			mostrarPersonajes();
    			System.out.println("introduce el numero del personaje;");
    			
    			nuper1=teclado.nextInt();
    			teclado.hasNextLine();
    		
    			
    			if(nuper1>=0 && nuper1<numper) {
    				mostrarHabilidades();
        			System.out.println("num de equipo");
        			
        			nequipo1=teclado.nextInt();
        			teclado.nextLine();
        			
        			if(nequipo1>=0 && nequipo1>=numhab) {
	        			salida =this.personajes.get(nuper1).addHabilidad(habilidades.get(nequipo1));
        			}else
        				error = true;
    			
    			}else
    				error = true;
    			
    			if(error) 
    				System.out.println("Error en la entrada");
    			
        		break;
        		default:
        			System.out.println("esa opcion no es valida");
        			break;
        	}
    		
    		return salida;
    	}
		
        public int modEquipo(Personaje personaje,Item item, boolean anyadir) {
        	int salida=-1;
        	boolean error = false;
        	
        	if(personajes.indexOf(personaje) == -1 || items.indexOf(item) == -1)
        		error = true;
        	
        	if(anyadir && !error) {
        		salida = personaje.addItem(item);
        	}
        	else {
        		salida = personaje.eliminarItem(item);
        	}
        	
        	return salida;
			
		}
		
//----------------------------------------------------------------
        //---modificar habilidades personaje----
        public int modHabPer() {
        	
        	int salida=-1;
        	int numero=0;
       
        	boolean error = false;
        	
        	System.out.println("que quieres eliminar habilidad personaje 1 o añadir habilidad personaje 2");
        	
        	numero=teclado.nextInt();
        	teclado.nextLine();
        	
        	switch(numero) {
        	case 1:
        		int nuper=0;
    			int nhabi=0;
    		
    			for(int i =0; i<personajes.size(); i++)
        		{
        			System.out.println(i+". "+personajes.get(i).getNombre());
        		}
    			
    			System.out.println("introduce el numero del personaje;");
    			
    			nuper=teclado.nextInt();
    			teclado.hasNextLine();
    			
    			if(nuper>=0 && nuper<numper) {
    				mostrarHabilidades();
        			System.out.println("num de habilidad");
        			
        			nhabi=teclado.nextInt();
        			teclado.nextLine();
        			
        			if(nhabi>=0 && nhabi>=numhab) {
	        			salida=this.personajes.get(nuper).eliminarHabilidad(habilidades.get(nhabi));
        			}else {
        				error = true;
        			}
    			
    			}else {
    				error = true;
    			}
    			
    			if(error) {
    				System.out.println("Error en la entrada");
    			}
    			
        		break;
        		
        	case 2:
        		int nuper1=0;
    			int nhabi1=0;
    			mostrarPersonajes();
    			System.out.println("introduce el numero del personaje;");
    			
    			nuper1=teclado.nextInt();
    			teclado.hasNextLine();
    		
    			
    			if(nuper1>=0 && nuper1<numper) {
    				mostrarHabilidades();
        			System.out.println("num de personaje");
        			
        			nhabi1=teclado.nextInt();
        			teclado.nextLine();
        			
        			if(nhabi1>=0 && nhabi1>=numhab) {
	        			salida=this.personajes.get(nuper1).addHabilidad(habilidades.get(nhabi1));
        			}else {
        				error = true;
        			}
    			
    			}else {
    				error = true;
    			}
    			
    			if(error) {
    				System.out.println("Error en la entrada");
    			}
    			
        		break;
        		default:
        			System.out.println("esa opcion no es valida");
        			break;
        	}
    		
    		return salida;
        	
        }
        
         public int modHabPer(Personaje personaje,Habilidad habilidad,boolean anyadir) {
        	 	int salida=-1;
	         	boolean error = false;
	    //comprobamos como queremos modificarlo si no los encuentra nos manda erros 	
	         	if(personajes.indexOf(personaje) == -1 || habilidades.indexOf(habilidad) == -1)
	         		error = true;
	         	if(!error) {
		         	if(anyadir)
		         		salida = personaje.addHabilidad(habilidad);
		         	else
		         		salida = personaje.eliminarHabilidad(habilidad);
	         	}
	         	//si los encontra añade o sino elimina
	         	return salida;
        	
        }
 //-----------------------------------------------------------------
        //----mostrar habilidades------------------
      
     	public void mostrarHabilidades()
     	{
     		
     		for(int i=0;i<habilidades.size();i++)
     		{
     			 habilidades.get(i).visualizarBasico();
     		}
     	}
 
     	//--mostrar personajes---------------
     	
     	public void mostrarPersonajes()
    	{
    		for(int i =0; i<personajes.size(); i++)
    		{
    			personajes.get(i).visualizarBasico();
    		}
    	}
 

  //-----mostrar intems  	
    	public void mostrarItems()
    	{
    		for(int i =0; i<items.size(); i++)
    		{
    			items.get(i).visualizarBasico();
    		}
    	}
     	
     	
     	//------------------------------------
    	//mostrar misiones 
    	public void mostrarMisiones()
    	{
    		for(int i =0; i<50; i++)
    		{
    			if(misiones[i] != null)
    			{
    				misiones[i].visualizarBasico();
    			}
    			
    		}
    	}
     	
     	//-----------mostrar zonas-------
     	public void mostrarZona()
    	{
    		for(int i =0; i<zonas.length; i++)
    		{
    			zonas[i].visualizarBasico();
    		}
    	}
	
	//--------------------------------------
	public boolean eliminarHabItem() {
		boolean salida=false;
		System.out.println("introduce el item a usar");
		for(int i=0;i<numitem;i++)
		{
			System.out.println("items:"+i);
			items.get(i).visualizarBasico();
		}

		int pitem =teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("introduce la habilidad a eliminar ");
		for(int i=0;i<numhab;i++)
		{
			System.out.println("habilidad:"+i);
			habilidades.get(i).visualizarBasico();
		}
		int phabi =teclado.nextInt();
		teclado.nextLine();
		
		// compro existan : item + habilidad ; 
		if (pitem > items.size() ||  pitem < 0 ) {
			System.out.println("el item no existe");
			
		}else {
			if (phabi > items.size() ||  phabi < 0 ) {
				System.out.println("la habilidad no existe");
			}else {
				// eliminamos la habilidad  ; 
				salida = eliminarHabItem(habilidades.get(phabi),items.get(pitem)); 
			}
		}
	
		return salida;
		
	}
	
	//eliminar habilidad del item
    public boolean eliminarHabItem(Habilidad habilidad,Item item) {
    	boolean salida=false;
    	//si lo encunentra  usando el 
    	if(items.indexOf(item) > -1 && habilidades.indexOf(habilidad) > -1)
    		salida = items.get(items.indexOf(item)).eliminarHabilidad(habilidades.get(habilidades.indexOf(habilidad)));
    	         //devuelve el objeto en items(posicion de item en items).elminamos(objtos(posicion de dicha habilidad))
		return salida;
	}
    
    public int eliminarPersonajeAZona(Personaje personaje,Zona zona) {
    	int salida=0;
    	boolean encontrado = false;
    	int pos = 0;
    	
    	encontrado = zona.tiene(personaje);
    	
    	if(personajes.indexOf(personaje) > -1 && encontrado)
    		salida = zonas[pos].eliminarPersonaje(personaje);
    	
		return salida;
	}
    
    public int addPersonajeAZona(Personaje personaje,Zona zona) {
    	int salida=0;
    	boolean encontrado = false;
    	int pos=0;
    	
    	for(int i = 0; i < numzonas; i++)
    		if(zonas[i].esIgual(zona)) {
    			encontrado = true;
    			pos = i;
    		}
    	
    	if(personajes.indexOf(personaje) > -1 && encontrado)
    	{
    		salida= zonas[pos].addPersonaje(personaje);
    	}
    	
    	return salida;

    }
	
	

//---obtenerPosHabilidad------------
	
	

	//
	public int obtenerPosHabilidad(String nombre)
	{
		int salida = -1;
		Habilidad aux = new Habilidad(nombre,0,0,"");
		
		for(int i = 0; i<numhab; i++)
		{
			if(habilidades.get(i).esIgual(aux))
			{
				salida =i;
			}
		}
		
		
		return salida;
	}
	//obtenemos pososicion de personaje
	public int obtenerPosPersonaje(String nombre)
	{
		int salida = -1;
		Personaje aux = new Personaje("","",0,0,0,0,0,null,null,false,false);
		
		for(int i = 0; i<numper; i++)
		{
			if(personajes.get(i).esIgual(aux))
			{
				salida =i;
			}
		}
		
		
		return salida;
	}
	
	//----------------------------------------------------------
	//--------modificar programa para base de datos mysql--------
	
	
	public  void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL cÃ³digo especÃ­fico: " + e.getErrorCode());
	  }
	
	
	public void guardarDatosHabilidades() {
		 

	    String basedatos = "juego";
	    String host = "localhost";
	    String port = "3307";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "S1m@cet420Seguro";

	   String nombre="";
	    int energia=0;
	    String tipo="";
	    int vida=0;

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s = (Statement) c.createStatement()) {

	    	int nFil  =0;
	    		  for(int i=0;i<habilidades.size();i++) {
		                
	                 nombre=habilidades.get(i).getNombre();
	                 energia=habilidades.get(i).getEnergia();
	                 tipo=habilidades.get(i).getTipo();
	                 vida=habilidades.get(i).getVida();
	                 
	                 
	                 
	        	       nFil = s.executeUpdate("INSERT INTO habilidades (nombre,energia,tipo,vida) VALUES( '"+nombre+"' , "+energia+" , '"+tipo+"' , "+vida+" )");  
	            }	  

	      System.out.println(nFil + " Filas insertadas.");

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }
	    
		   	
	//--------------------------guardarDatosPersonajes()
	
	public void guardarDatosPersonajes() {
		 

	    String basedatos = "juego";
	    String host = "localhost";
	    String port = "3307";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "S1m@cet420Seguro";
//nombre,clase,vida_max,vida_actual,energia_actual,monedas,energia_max,auxhab,
		//	new Item[5],npc,hostil
	    String nombre = "";
		 String clase="";
	    int vida_max = 0;
		 int energia_max=0;
		 int vida_actual = 0;
		 int energia_actual=0;		 
		 int monedas=0;
	    

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s = (Statement) c.createStatement()) {

	    	int nFil  =0;
	    		  for(int i=0;i<personajes.size();i++) {
		                
	                 nombre=personajes.get(i).getNombre();
	                 clase=personajes.get(i).getClase();
	                 vida_max=personajes.get(i).getVida_max();
	                 energia_max=personajes.get(i).getEnergia_max();
	                 vida_actual=personajes.get(i).getVida_actual();
	                 energia_actual=personajes.get(i).getEnergia_actual();
	                 monedas=personajes.get(i).getMonedas();
	                 
	                 
	                 
	        	       nFil = s.executeUpdate("INSERT INTO habilidades (nombre,clase,vida_max,energia_max,vida_actual,energia_actual,monedas) VALUES( '"+nombre+"' , '"+clase+"' ,"+vida_max+" , '"+energia_max+"' ,'"+vida_actual+"' ,'"+energia_actual+"' ,'"+monedas+"' )");  
	            }	  

	      System.out.println(nFil + " Filas insertadas.");

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  }
	public void LeerDatosPersonaje() {
		 

	    String basedatos = "juego";
	    String host = "localhost";
	    String port = "3307";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "S1m@cet420Seguro";

	    String nombre = "";
		 String clase="";
	    int vida_max = 0;
		 int energia_max=0;
		 int vida_actual = 0;
		 int energia_actual=0;		 
		 int monedas=0;
		 boolean npc=false;
		 boolean hostil=false;
		 

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s =(Statement) c.createStatement();
	            ResultSet rs = s.executeQuery("SELECT * FROM habilidades")) {

	      
	      while (rs.next()) {
	       
	 		 
	 		 	 
	 		 
	 		 
	    	  nombre=rs.getString("nombre");
	    	  vida_max=rs.getInt("vida_max");
	    	  clase=rs.getString("clase");
	    	  energia_max=rs.getInt("energia_max");
	    	  vida_actual=rs.getInt("vida_actual");
	    	  energia_max=rs.getInt("energia_actual");
	    	  monedas=rs.getInt("monedas");
	    	  Habilidad [] habs=new Habilidad[5];
	    	  Item[] items=new Item[5];
 			
	    	  Personaje aux=new Personaje(nombre,clase,vida_max,vida_actual,energia_actual,monedas,energia_max,habs,items,npc,hostil);
			 			
	    	  anyadirPersonaje(aux);
	      }

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  
	  }
	
	public void LeerDatosHabilidades() {
		 

	    String basedatos = "juego";
	    String host = "localhost";
	    String port = "3307";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "S1m@cet420Seguro";

	    String nombre="";
	    int energia=0;
	    String tipo="";
	    int vida=0;

	    try (
	            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	            Statement s =(Statement) c.createStatement();
	            ResultSet rs = s.executeQuery("SELECT * FROM habilidades")) {

	      
	      while (rs.next()) {
	        
	    	  
	    	  nombre=rs.getString("nombre");
	    	  energia=rs.getInt("energia");
	    	  tipo=rs.getString("tipo");
	    	  vida=rs.getInt("vida");
	    	  
	    	  Habilidad aux=new Habilidad(nombre, vida, energia,tipo);
	    	  anyadirHabilidad(aux);
	      }

	    } catch (SQLException e) {
	      muestraErrorSQL(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	  
	  }
	
	    public void guardarEnFichero(){
	      
	        
	        try {
	        	
	            FileWriter file = new FileWriter("C:\\DAM\\habilidades.txt");
	            BufferedWriter out = new BufferedWriter(file);
	            
	            for(int i=0;i<habilidades.size();i++) {
	                
	                  String texto = habilidades.get(i).toString();
	                  out.write(texto);
	                  out.newLine();
	            }
	            out.close();
	            file.close();
	            
	        } catch (IOException e) {
	        	System.out.println(e.getMessage());
	        }
	        
	     // personaje   
	        try {
	        	
	            FileWriter file = new FileWriter("C:\\DAM\\personajes.txt");
	            BufferedWriter out = new BufferedWriter(file);
	            
	            for(int i=0;i<personajes.size();i++) {
	                
	                  String texto = personajes.get(i).toString();
	                  out.write(texto);
	                  out.newLine();
	            }
	            out.close();
	            file.close();
	            
	        } catch (IOException e) {
	        	System.out.println(e.getMessage());
	        }
	    
	    
	    //forma alternativa que genera el archivo y ademas condidica en utf-8	
	    	/*
	        try {
	            PrintWriter writer = new PrintWriter("C:\\DAM\\personajes.txt", "UTF-8");
	           
	            for(int i=0;i<personajes.size();i++) {
	                  writer.println(personajes.get(i));
	            }
	            writer.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        */
	    }
	        
	        
	    
	     public void leerDeFichero() {
	    	 
	    	 	habilidades = new ArrayList<Habilidad>();
		 		items = new ArrayList<Item>();		
		 		personajes= new ArrayList<Personaje>();
		 		
		 		numhab=0;
		 		numitem=0;
		 		numper=0;
		 		numzonas=0;
		 		num_mis=0;
		 		num_users=0;
		 		num_hab_item=0;
		 		
		 		misiones=new Mision[50];
		 		users=new Usuario[50];
		 		zonas=new Zona[50];
	    	 
	         try {
	        	 FileReader file = new FileReader("C:\\DAM\\habilidades.txt");
	        	 BufferedReader in = new BufferedReader(file);
	        	 	
	        	 String c = "";
	        	 
	        	 while((c = in.readLine()) != null)
	        	 {
	        		 boolean vacion = false;
	        		 
	        		 if(c.length() == 0)
	        		 {
	        			 vacion = true;
	        		 }
	        		 
	        		 if(!vacion)
	        		 {
	        			 String campos[] = c.split(";");
	        			 
	        			 String nombre = campos[0];
	        			 int vida = Integer.parseInt(campos[1]);
	        			 int energia = Integer.parseInt(campos[2]);
	        			 String tipo = campos[3];
	        			 
	        			 Habilidad aux = new Habilidad(nombre, vida, energia, tipo);
	        			 
	        			 anyadirHabilidad(aux);
	        		 }
	        		 c= "";
	        	 }
	        	 in.close();
	        	 file.close();
	         }catch(IOException e){
	        	 System.out.println(e.getMessage());
	         }
	         
	         
	         try {
	        	 FileReader file = new FileReader("C:\\DAM\\personajes.txt");
	        	 BufferedReader in = new BufferedReader(file);
	        	 	
	        	 String c = "";
	        	 
	        	 while((c = in.readLine()) != null)
	        	 {
	        		 boolean vacion = false;
	        		 
	        		 if(c.length() == 0)
	        		 {
	        			 vacion = true;
	        		 }
	        		 
	        		 if(!vacion)
	        		 {
	        			 String campos[] = c.split(";");
	        			//pruebas para ver que me devuelve en cada campo 
	        			 System.out.println("nombre :"+ campos[0]);
	        			 System.out.println("clase : "+campos[1]);
	        			 System.out.println("vidamax : "+campos[2]);
	        			 System.out.println("energia max : "+campos[3]);
	        			 System.out.println("vida aact : "+campos[4]);
	        			 System.out.println("energia act : "+campos[5]);
	        			 System.out.println("monedas : "+campos[6]);
	        			 System.out.println("NPC : "+campos[7]);
	        			 
	        			 //nombre;clase;vida_max;energia_max;vida_actual;monedas;npc;hostil
	        			 //
	        			 String nombre = campos[0];
	        			 String clase=campos[1];
	        			 /*
	        			 	this.nombre+";"
        					+this.clase+";"
        					this.vida_max+";"+
        					this.energia_max+";"+
        					this.vida_actual+";"+
        					this.energia_actual+";"+
        					this.monedas+";"+
        					this.npc+";"+
        					this.hostil+";";
        					*/
	        			 
	        			 int vida_max = Integer.parseInt(campos[2]);
	        			 int energia_max=Integer.parseInt(campos[3]);
	        			 int vida_actual = Integer.parseInt(campos[4]);
	        			 int energia_actual=Integer.parseInt(campos[5]);
	        			 
	        			 int monedas=Integer.parseInt(campos[6]);
	        			 boolean npc= Boolean.parseBoolean(campos[7]);
	        			 boolean hostil = Boolean.parseBoolean(campos[8]);
	        			 
	        			 String[] nombrehab=campos[9].split(", ");//crea espacio
	        			 
	        			 Habilidad[] auxhab = new Habilidad[nombrehab.length];
	        			 //creamos un auxiliar habilidad con tamaño nombre de habilidades
	        			 int numhab = 0;
	        			 //recorremos el array habilidades y en cada habilidades  nos devuelve el nombre que sea igual al nombre de habilidades
	        			 for(int i = 0; i < nombrehab.length; i++)
	        				 for(int j = 0; j < this.habilidades.size(); j++)
	        					 if(this.habilidades.get(j).getNombre().equals(nombrehab[i])) {
	        						 auxhab[numhab] = this.habilidades.get(i);//guarda el objeto habilidad en el auxiliar
	        						 numhab++;//tenemos una nueva habilidad
	        					 }
	        			 
	        			 
	        			// String nombre,String clase,int vida_max,int vida_actual,int energia_actual,int energia_max,int monedas,
	        			// Habilidad[] habilidades, Item[] equipo,boolean npc,boolean hostil
	        			Personaje aux = new Personaje(nombre,clase,vida_max,vida_actual,energia_actual,monedas,energia_max,auxhab,
	        			 			new Item[5],npc,hostil);
	        		//creamos un auxciliar de personajes , creamos un nuevo aux de tipor item de tamaño 5	 
	        			 anyadirPersonaje(aux);
	        		 }
	        		 c= "";
	        	 }
	        	 in.close();
	        	 file.close();
	         }catch(IOException e){
	        	 System.out.println(e.getMessage());
	         }
	     
	     
	     /*
	      try {
	            Scanner input = new Scanner(new File("C:\\DAM\\personajes.txt"));
	            while (input.hasNextLine()) {
	                String line = input.nextLine();
	                System.out.println(line);
	            }
	            input.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        */
	    }
	    
  }
	
	
	
	
		
	
	
	
		
	

	
		
	




