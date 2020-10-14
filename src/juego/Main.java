package juego;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		/*
		Gestor gestor = new Gestor();
		
		Scanner teclado = new Scanner (System.in);
		Habilidad[] habilidades = new Habilidad[10];
		Item[] items = new Item[60];
		Personaje personajes[] = new Personaje[55];
		
		habilidades[0]= new Habilidad("suspender",-100,0,"profesor");
		habilidades[1]= new Habilidad("atropellar",-500,100,"coche");
		habilidades[2]= new Habilidad("expulsar",0,100,"direcci�n");
		habilidades[3]= new Habilidad("aprobar raspao",50,5,"alumno");
		
		
		Habilidad[] array = new Habilidad[5];
		array[0] = habilidades[1];
		array[1] = habilidades[1];
		array[2] = habilidades[2];
	
		//ITEM

				for(int i=0;i<20;i++)
					items[i] = new Armadura("Armadura " + i, i, array, i, i);
				for(int i=20;i<40;i++)
					items[i] = new Consumible("Consumible " + i, i, array, i);
				for(int i=40;i<60;i++)
					items[i] = new Arma("Arma " + i, i, array, i, i);
				Item auxitems []  = new Item[5];
				auxitems[0] = items[0];
				auxitems[1] = items[20];
				auxitems[2] = items[40];
				
				
		Personaje per1 = new Personaje("campa","cabo",100,10,25,100,100,habilidades,items,true,true);
		gestor.anyadirPersonaje(per1);
		gestor.guardarEnFichero();
				
Scanner teclado = new Scanner(System.in);
		
		//CREACIÃ“N ARRAYS AUXILIARES
		//Gestor
		Habilidad habilidades[] = new Habilidad[55];
		Item items[] = new Item[60];
		Personaje personajes[] = new Personaje[55];
		Zona zonas[] = new Zona[55];
		Mision misiones[] = new Mision[55];
		
		//HABILIDADES
		for(int i=0; i<55;i++)
			habilidades[i] = new Habilidad("Habilidad"+ i,i+1,i+1,"tipo" + 1);
		
		
		

		
		Habilidad auxhabilidad[] = new Habilidad[5];
		auxhabilidad[0] = habilidades[0];
		auxhabilidad[1] = habilidades[1];
		auxhabilidad[2] = habilidades[2];
		
		//ITEM
		for(int i=0;i<20;i++)
			items[i] = new Armadura("Armadura " + i, i, auxhabilidad, i, i);
		for(int i=20;i<40;i++)
			items[i] = new Consumible("Consumible " + i, i, auxhabilidad, i);
		for(int i=40;i<60;i++)
			items[i] = new Arma("Arma " + i, i, auxhabilidad, i, i);
		Item auxitems []  = new Item[5];
		auxitems[0] = items[0];
		auxitems[1] = items[20];
		auxitems[2] = items[40];
		
		
	
		
		//Personaje
		for(int i=0;i<55;i++)
		{
			personajes[i] = new Personaje("nombre "+i, "clase "+i, 200,200,200,200,0,auxhabilidad,auxitems, false, false );
		}
		
		Personaje[] auxpersonajes = new Personaje[55];
		auxpersonajes[0] = personajes[0];
		auxpersonajes[1] = personajes[1];
		auxpersonajes[2] = personajes[2];
		

		teclado.nextLine();
		Scanner teclado = new Scanner(System.in);
		
		//CREACIÃ“N ARRAYS AUXILIARES
		//Gestor
		Habilidad habilidades[] = new Habilidad[55];
		Item items[] = new Item[60];
		Personaje personajes[] = new Personaje[55];
		Zona zonas[] = new Zona[55];
		Mision misiones[] = new Mision[55];
		
		//HABILIDADES
		for(int i=0; i<55;i++)
			habilidades[i] = new Habilidad("Habilidad"+ i,i+1,i+1,"tipo" + 1);
		
		
		

		
		Habilidad auxhabilidad[] = new Habilidad[5];
		auxhabilidad[0] = habilidades[0];
		auxhabilidad[1] = habilidades[1];
		auxhabilidad[2] = habilidades[2];
		
		//ITEM
		for(int i=0;i<20;i++)
			items[i] = new Armadura("Armadura " + i, i, auxhabilidad, i, i);
		for(int i=20;i<40;i++)
			items[i] = new Consumible("Consumible " + i, i, auxhabilidad, i);
		for(int i=40;i<60;i++)
			items[i] = new Arma("Arma " + i, i, auxhabilidad, i, i);
		Item auxitems []  = new Item[5];
		auxitems[0] = items[0];
		auxitems[1] = items[20];
		auxitems[2] = items[40];
		
		
	
		
		//Personaje
		for(int i=0;i<55;i++)
		{
			personajes[i] = new Personaje("nombre "+i, "clase "+i, 200,200,200,200,0,auxhabilidad,auxitems, false, false );
		}
		
		Personaje[] auxpersonajes = new Personaje[55];
		auxpersonajes[0] = personajes[0];
		auxpersonajes[1] = personajes[1];
		auxpersonajes[2] = personajes[2];
		

		teclado.nextLine();
		Gestor gestor = new Gestor();
		System.out.println("Comprobar Habilidades vacias");
		gestor.mostrarHabilidades();
		teclado.nextLine();
		
		System.out.println("Comprobar Personajes vacios");
		gestor.mostrarPersonajes();
		teclado.nextLine();
		
		
		gestor.guardarEnFichero();
		System.out.println("Comprobar ficheros vacio");
		teclado.nextLine();
		
		for(int i =0;i<5; i++)
		{
			gestor.anyadirHabilidad(habilidades[i]);
		}
		gestor.anyadirItem(items[0]);
		gestor.anyadirItem(items[20]);
		gestor.anyadirItem(items[40]);
		for(int i =0;i<5; i++)
		{
			gestor.anyadirPersonaje(personajes[i]);
		}
		
		
		gestor.leerDeFichero();
			System.out.println("Comprobar Habilidades vacias");
		gestor.mostrarHabilidades();
		teclado.nextLine();
		
		System.out.println("Comprobar Personajes vacios");
		gestor.mostrarPersonajes();
		teclado.nextLine();
		gestor.guardarEnFichero();
		System.out.println("Comprobar ficheros vacios despues de crear y leer vacio");
		teclado.nextLine();
		
		for(int i =0;i<5; i++)
		{
			gestor.anyadirHabilidad(habilidades[i]);
		}
		gestor.anyadirItem(items[0]);
		gestor.anyadirItem(items[20]);
		gestor.anyadirItem(items[40]);
		for(int i =0;i<5; i++)
		{
			gestor.anyadirPersonaje(personajes[i]);
		}
		
	
		gestor.guardarEnFichero();
		System.out.println("Comprobar ficheros con datos");
		teclado.nextLine();
		
		for(int i =0;i<10; i++)
		{
			gestor.anyadirHabilidad(habilidades[i]);
		}
		gestor.anyadirItem(items[0]);
		gestor.anyadirItem(items[20]);
		gestor.anyadirItem(items[40]);
		for(int i =0;i<10; i++)
		{
			gestor.anyadirPersonaje(personajes[i]);
		}
		System.out.println("deben haber 10 habilidades y 10 personajes");
		teclado.nextLine();
		System.out.println("10 Hab");
		teclado.nextLine();
		
		gestor.mostrarHabilidades();
		teclado.nextLine();
		
		System.out.println("10 perso");
		teclado.nextLine();
		
		gestor.mostrarPersonajes();
		teclado.nextLine();
		
		System.out.println("leemos para limpiary quedaran 5 ");
		teclado.nextLine();
		System.out.println("5 Hab");
		teclado.nextLine();
		gestor.leerDeFichero();
		gestor.mostrarHabilidades();
		
		teclado.nextLine();
		
		System.out.println("5 perso");
		teclado.nextLine();
		
		gestor.mostrarPersonajes();
		teclado.nextLine();
		*/
		
		/*
		gestor.anyadirPersonaje();
		gestor.anyadirZona();
		gestor.anyadirItem(items[0]);
		gestor.anyadirMision();
		
		gestor.mostrarMisiones();
		*/
		Scanner teclado = new Scanner(System.in);
		
		//CREACIÓN ARRAYS AUXILIARES
		Habilidad habilidades[] = new Habilidad[51];
		Item items[] = new Item[61];
		Personaje personajes[] = new Personaje[51];
		Zona zonas[] = new Zona[51];
		Mision misiones[] = new Mision[51];
		
		
		Gestor gestor = new Gestor();
		
		
		
		//HABILIDADES
		for(int i=0; i<51;i++)
			habilidades[i] = new Habilidad("Habilidad"+ i,i+1,i+1,"tipo" + 1);
		
		
		

		Habilidad auxhabilidad[] = new Habilidad[5];
		auxhabilidad[0] = habilidades[3];
		auxhabilidad[1] = habilidades[6];
		auxhabilidad[2] = habilidades[9];
		
		gestor.anyadirHabilidad(habilidades[0]);
		gestor.anyadirHabilidad(habilidades[1]);
		gestor.anyadirHabilidad(habilidades[3]);
		gestor.anyadirHabilidad(habilidades[5]);
		gestor.anyadirHabilidad(habilidades[4]);
		gestor.anyadirHabilidad(habilidades[6]);
		gestor.anyadirHabilidad(habilidades[9]);
		
		//ITEM
		for(int i=0;i<20;i++)
			items[i] = new Armadura("Armadura " + i, i, auxhabilidad, i, i);
		for(int i=20;i<40;i++)
			items[i] = new Consumible("Consumible " + i, i, auxhabilidad, i);
		for(int i=40;i<61;i++)
			items[i] = new Arma("Arma " + i, i, auxhabilidad, i, i);
		Item auxitems []  = new Item[5];
		auxitems[0] = items[0];
		auxitems[1] = items[24];
		auxitems[2] = items[47];
		
		
		gestor.anyadirItem(items[0]);
		gestor.anyadirItem(items[1]);
		gestor.anyadirItem(items[2]);
		gestor.anyadirItem(items[24]);
		gestor.anyadirItem(items[47]);
		

		
		//Personaje
		for(int i=0;i<51;i++)
		{
			personajes[i] = new Personaje("nombre "+i, "clase "+i, 200,200,200,200,0,auxhabilidad,auxitems, false, false );
		}
		
		Personaje[] auxpersonajes = new Personaje[10];
		auxpersonajes[0] = personajes[0];
		auxpersonajes[1] = personajes[8];
		auxpersonajes[2] = personajes[9];
		
		gestor.anyadirPersonaje(personajes[0]);
		gestor.anyadirPersonaje(personajes[1]);
		gestor.anyadirPersonaje(personajes[2]);
		gestor.anyadirPersonaje(personajes[8]);
		gestor.anyadirPersonaje(personajes[9]);
	
		//Zona
		for(int i=0;i<51;i++)
		{
			zonas[i] = new Zona("zona "+i, i,auxpersonajes);
		}
		
		
		gestor.anyadirZona(zonas[1]);
		
		
		//Misiones
		for(int i=0;i<51;i++)
		{
			misiones[i] = new Mision("nombre "+i, i, personajes[i], zonas[i], items[i], i);
		}
		

		
		
		
		
		
		
		
		
	//asigHabItem
		if(gestor.asigHabItem(habilidades[3],items[0]))
			System.out.println("Error asigHabItem 1");
		else
			System.out.println("Correcto asigHabItem 1");
		
		if(gestor.asigHabItem(habilidades[5],items[1]))
			System.out.println("Correcto asigHabItem 1");
		else
			System.out.println("Error asigHabItem 1");
		
		teclado.nextLine();
		System.out.println("comprobamos el item");
		items[1].visualizar();
		teclado.nextLine();
		//eliminarHabItem
		/*if(gestor.eliminarHabItem(habilidades[4],items[1]))
			System.out.println("Error eliminarHabItem 1");
		else
			System.out.println("Correcto eliminarHabItem 1");
		
		if(gestor.eliminarHabItem(habilidades[5],items[1]))
			System.out.println("Correcto eliminarHabItem 2");
		else
			System.out.println("Error eliminarHabItem 2");
		
		if(gestor.eliminarHabItem(habilidades[5],items[1]))
			System.out.println("Error eliminarHabItem 3");
		else
			System.out.println("Correcto eliminarHabItem 3");
		
		teclado.nextLine();
		System.out.println("comprobamos el item");
		items[1].visualizarBasico();
		teclado.nextLine();
		
		
		if(gestor.modEquipo(personajes[1],items[0],true)>0)
			System.out.println("Error modEquipo A 1");
		else
			System.out.println("Correcto modEquipo A 1");
		
		if(gestor.modEquipo(personajes[1],items[2],true)>0)
			System.out.println("Correcto modEquipo A 2");
		else
			System.out.println("Error modEquipo A 2");
		
		
		teclado.nextLine();
		System.out.println("comprobamos el pj");
		personajes[1].visualizarBasico();
		teclado.nextLine();
		
		if(gestor.modEquipo(personajes[1],items[1],false)>0)
			System.out.println("Error modEquipo E 1");
		else
			System.out.println("Correcto modEquipo E 1");
		
		if(gestor.modEquipo(personajes[1],items[2],false)>0)
			System.out.println("Correcto modEquipo E 2");
		else
			System.out.println("Error modEquipo E 2");
		
		if(gestor.modEquipo(personajes[1],items[2],false)>0)
			System.out.println("Error modEquipo E 3");
		else
			System.out.println("Correcto modEquipo E 3");
		
		teclado.nextLine();
		System.out.println("comprobamos el pj");
		personajes[1].visualizarBasico();
		teclado.nextLine();*/
		
		
		
		//ModHabPer
		if(gestor.modHabPer(personajes[1],habilidades[3],true)>0)
			System.out.println("Error modHabPer A 1");
		else
			System.out.println("Correcto modHabPer A 1");
		
		if(gestor.modHabPer(personajes[1],habilidades[1],true)>0)
			System.out.println("Correcto modHabPer A 2");
		else
			System.out.println("Error modHabPer A 2");
		
		
		teclado.nextLine();
		System.out.println("comprobamos el pj");
		personajes[1].visualizarBasico();
		teclado.nextLine();
		
		if(gestor.modHabPer(personajes[1],habilidades[0],false)>0)
			System.out.println("Error modHabPer E 1");
		else
			System.out.println("Correcto modHabPer E 1");
		
		if(gestor.modHabPer(personajes[1],habilidades[3],false)>0)
			System.out.println("Correcto modHabPer E 2");
		else
			System.out.println("Error modHabPer E 2");
		
		if(gestor.modHabPer(personajes[1],habilidades[3],false)>0)
			System.out.println("Error modHabPer E 3");
		else
			System.out.println("Correcto modHabPer E 3");
		
		teclado.nextLine();
		System.out.println("comprobamos el pj");
		personajes[1].visualizarBasico();
		teclado.nextLine();
		
		
		//addPersonajeAZona
		if(gestor.addPersonajeAZona(personajes[8],zonas[1])>0)
			System.out.println("Error addPersonajeAZona 1");
		else
			System.out.println("Correcto addPersonajeAZona 1");
		
		if(gestor.addPersonajeAZona(personajes[1],zonas[1])>0)
			System.out.println("Correcto addPersonajeAZona 2");
		else
			System.out.println("Error addPersonajeAZona 2");
		
		teclado.nextLine();
		System.out.println("comprobamos la zona");
		zonas[1].visualizarBasico();
		teclado.nextLine();
		
		//eliminarPersonajeAZona
		if(gestor.eliminarPersonajeAZona(personajes[2],zonas[1])>0)
			System.out.println("Error eliminarPersonajeAZona 1");
		else
			System.out.println("Correcto eliminarPersonajeAZona 1");
		
		if(gestor.eliminarPersonajeAZona(personajes[0],zonas[1])>0)
			System.out.println("Correcto eliminarPersonajeAZona 2");
		else
			System.out.println("Error eliminarPersonajeAZona 2");
		if(gestor.eliminarPersonajeAZona(personajes[0],zonas[1])>0)
			System.out.println("Error eliminarPersonajeAZona 3");
		else
			System.out.println("Correcto eliminarPersonajeAZona 3");
		
		teclado.nextLine();
		System.out.println("comprobamos la zona");
		zonas[1].visualizarBasico();
		teclado.nextLine();
		
		Gestor ver=new Gestor();
		ver.menu();
		
	}
	
	

}
