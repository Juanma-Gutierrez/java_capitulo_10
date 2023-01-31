import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
public class Ejercicio19 {
    private static ArrayList<String> obtenerSinonimos(String palabra, HashMap<String, String> dic){
        String traduccion = dic.get(palabra);
        ArrayList<String> sinonimos = new ArrayList<String>();
        for(Map.Entry entrada:dic.entrySet()){
            if(!entrada.getKey().equals(palabra) && entrada.getValue().equals(traduccion))
                sinonimos.add((String)entrada.getKey());
            
        }
        return sinonimos;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dic = new HashMap<String, String>();
        dic.put("caliente", "hot");
        dic.put("rojo", "red");
        dic.put("ardiente", "hot");
        dic.put("verde", "green");
        dic.put("agujetas", "stiff");
        dic.put("abrasador", "hot");
        dic.put("hierro", "iron");
        dic.put("grande", "big");
        boolean salir = false;
        do {
            System.out.println("Introduzca una palabra y le daré los sinónimos: ");
            String palabra = sc.nextLine();
            if(palabra.equals("salir"))
                salir = true;
            else{
                if(dic.containsKey(palabra)){
                    ArrayList<String> sinonimos = obtenerSinonimos(palabra, dic);
                    if(sinonimos.size()>1){
                        String cadena=String.format("Sinónimos de %s: ", palabra);
                        for(int i=0; i < sinonimos.size()-1; i++){
                            cadena+=String.format("%s, ", sinonimos.get(i));
                        }
                        cadena+=sinonimos.get(sinonimos.size()-1);
                        System.out.println(cadena);
                        
                    }
                    else
                        System.out.println("No conozco sinónimos de esa palabra");
                }
                else
                    System.out.println("No conozco esa palabra");
            }
            
        } while (!salir); 
        sc.close();
    }
}
