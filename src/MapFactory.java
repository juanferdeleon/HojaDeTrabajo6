import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map Factory class
 * @author Juanfer De Leon
 */
public class MapFactory {

    /**
     * Specific map type is created
     * @param mapType
     * @return Specific map type is returned
     */
    public Map makeMap(String mapType){

        Map map = null;

        if (mapType.equals("HashMap")){
            map = new HashMap();
        } else if (mapType.equals("TreeMap")){
            map = new TreeMap();
        } else if (mapType.equals("LinkedHashMap")){
            map = new LinkedHashMap();
        }

        return map;

    }
}
