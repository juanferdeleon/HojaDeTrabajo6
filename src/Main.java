import java.io.*;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Juanfer De Leon
 */
public class Main {

    /**
     * Main
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Boolean mapIsNotSelected = true;
        Map<Integer, Card> map = null;
        MapFactory mapFactory = new MapFactory();

        while (mapIsNotSelected){

            System.out.println(mainMenu());
            System.out.print("Seleccionar la implementacion de MAP:");

            Scanner input = new Scanner(System.in);
            String op = input.next();

            switch (op){
                case "1":
                    map = mapFactory.makeMap("HashMap");
                    map = readFile(map);
                    mapIsNotSelected = false;
                    break;
                case "2":
                    map = mapFactory.makeMap("TreeMap");
                    map = readFile(map);
                    mapIsNotSelected = false;
                    break;
                case "3":
                    map = mapFactory.makeMap("LinkedHashMap");
                    map = readFile(map);
                    mapIsNotSelected = false;
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
        }

        Boolean whantsToContinue = true;

        while (whantsToContinue){

            System.out.println(secondaryMenu());
            System.out.print("Seleccione una opcion: ");

            Scanner input2 = new Scanner(System.in);
            String op2 = input2.next();

            switch (op2){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    whantsToContinue = false;
                    break;
                default:
                    break;
            }

        }


    }

    /**
     * Read file of cards
     * @param map
     * @return map of cards
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Map readFile(Map map)throws FileNotFoundException, IOException {

        File file = new File("cards_desc.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        Integer key = 1;

        while ((line = bufferedReader.readLine()) != null){

            String[] nameAndType = line.split("\\|");

            String cardName = nameAndType[0];
            String cardType = nameAndType[1];

            map.put(key, new Card(cardName, cardType));

            key++;

        }

        return map;
    }

    /**
     * Main menu
     * @return String of the main menu
     */
    public static String mainMenu(){
        return "\tMenu\n\n" +
                "1. HashMap\n" +
                "2. TreeMap\n" +
                "3. LinkedHashMap\n";
    }

    public static String secondaryMenu(){
        return "\tMenu\n\n" +
                "1. Agregar carta a coleccion de Usuario\n" +
                "2. Mostrar tipo de una carta especifica\n" +
                "3. Cartas existentes del Usuario\n" +
                "4. Cartas existentes del Usuario ordenadas por tipo\n" +
                "5. Cartas existentes\n" +
                "6. Cartas existentes ordenadas por tipo\n" +
                "7. Salir\n";
    }
}
