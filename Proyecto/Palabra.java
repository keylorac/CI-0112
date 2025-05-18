public class Palabra {
    private char[] letras; //Crea un array con cada letra de la palabra 
    private boolean[] letrasAdivinadas; //Marca true si la letra ya fue averiguada 


    public Palabra(String palabra){
        letras = palabra.toLowerCase().toCharArray(); //Convierte la palabra en un array de letras 
        letrasAdivinadas = new boolean[letras.length]; //Crea un array booleano del mismo tamaño que el de la palabra
        
    }
    
    public boolean intentarLetra(char letra){
        boolean acierto = false;

        //Recorre cada letra para ver si coincide con la ingresada 
        for (int i= 0; i < letras.length; i++){
            if( letras[i] == letra){
                letrasAdivinadas[i] = true; //Marca la letra como adivinada 
                acierto = true;
            }
        }
        return acierto; // Devuelve si la letra fue encontrada o no 

    }

    public boolean estaCompleta(){

        //Verifica si todas las letras han sido adivinadas 
        for (boolean adivinada : letrasAdivinadas){
            if (!adivinada) return false;
        }
        return true;
    } 
    public String obtenerProgreso(){
        StringBuilder progreso = new StringBuilder();

        //Construye una cadena con las letras adivinadas y guiones bajos
        for (int i = 0; i < letras.length; i++){
            if (letrasAdivinadas[i]){
                progreso.append(letras[i]).append(" ");
            } else{
                progreso.append("_ ");

            }

        }
        return progreso.toString();
    }

    public String obtenerPalabra(){
        return new String(letras); //Devuelve la palabra completa como string 
    
    }


}
