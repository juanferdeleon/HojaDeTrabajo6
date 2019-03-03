import javax.xml.catalog.CatalogResolver;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

//        Map<Integer, Card> map = new HashMap<>();
//        readFile(map);



    }

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

    public static String mainMenu(){
        return "\tMenu\n\n" +
                "1. HashMap\n" +
                "2. TreeMap\n" +
                "1. LinkedHashMap\n";
    }
}
