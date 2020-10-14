package juego;



public class Comprobacion {
	
	 String dni;

	 
     public void ValidadorDNI(String dni) {
         this.dni = dni;
     }

  
 public boolean validarDNI() {

      
     String letraMayuscula = ""; //Guardaremos la letra introducida en formato may�scula
   
        
     // Aqu� excluimos cadenas distintas a 9 caracteres que debe tener un dni y tambi�n si el �ltimo caracter no es una letra
     if(dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false ) {
         return false;
     }

      
     // Al superar la primera restricci�n, la letra la pasamos a may�scula
     letraMayuscula = (this.dni.substring(8)).toUpperCase();

     // Por �ltimo validamos que s�lo tengo 8 d�gitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuaci�n
     // Llamamos a los m�todos privados de la clase soloNumeros() y letraDNI()
     if(soloInt() == true && calcularLetra().equals(letraMayuscula)) {
         return true;
     }
     else {
         return false;
     }
 }

      boolean soloInt() {

         int i, j = 0;
         String numero = ""; 
         String miDNI = ""; 
         String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

         for(i = 0; i < this.dni.length() - 1; i++) {
             numero = this.dni.substring(i, i+1);

             for(j = 0; j < unoNueve.length; j++) {
                 if(numero.equals(unoNueve[j])) {
                     miDNI += unoNueve[j];
                 }
             }
         }

         if(miDNI.length() != 8) {
             return false;
         }
         else {
             return true;
         }
     }

      String calcularLetra() 
     {
     
    	 
     int miDNI = Integer.parseInt(this.dni.substring(0,8));
     int resto = 0;
     String miLetra = "";
     String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

     resto = miDNI % 23;

     miLetra = asignacionLetra[resto];

     return miLetra;
     		}
    }
	        

	