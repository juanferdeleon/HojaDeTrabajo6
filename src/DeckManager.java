import java.util.Map;

/**
 * @author Juanfer De Leon 
 */
public class DeckManager {

    /**
     * Adds a card to the userDeck just if it exists, if it does,
     * it removes the card from the general deck
     * @param map
     * @param userMap
     * @param cardName
     * @return True if it was successfully added, false if not.
     */
    public static boolean AddCard(Map<Integer, Card> map, Map<Integer, Card> userMap, String cardName){
        for (Map.Entry<Integer, Card> entry : map.entrySet()){
            if (entry.getValue().getCardName().equals(cardName)){
                if (userMap.isEmpty()){
                    userMap.put(1, entry.getValue());
                    map.remove(entry.getKey());
                    return true;
                } else {
                    userMap.put(userMap.size() + 1, entry.getValue());
                    map.remove(entry.getKey());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Shows the card type if it exists on general deck
     * @param map
     * @param cardName
     * @return Card type or null if it does not exists
     */
    public static String showCardType(Map<Integer, Card> map, String cardName){
        for (Map.Entry<Integer, Card> entry : map.entrySet()) {
            if (entry.getValue().getCardName().equals(cardName)){
                return "\nTipo de carta: " + entry.getValue().getCardType();
            }
        }
        return "\nLa carta ingresada NO existe";
    }

    /**
     * Shows all the cards on deck
     * @param userMap
     * @return all the cards
     */
    public static String showDeck(Map<Integer, Card> userMap){
        String userDeck = "";
        for (Map.Entry<Integer, Card> entry : userMap.entrySet()) {
            userDeck += entry.getValue() + "\n";
        }
        return userDeck;
    }

    /**
     * Organizes the deck by card type
     * @param userMap
     * @return
     */
    public static String showCleanDeck(Map<Integer, Card> userMap){
        String userDeckMonster = "\n\tCARTAS TIPO MONSTRUO\n\n";
        String userDeckSpell = "\n\tCARTAS TIPO HECHIZO\n\n";
        String userDeckTrap = "\n\tCARTAS TIPO TRAMPA\n\n";
        for (Map.Entry<Integer, Card> entry : userMap.entrySet()) {
            if (entry.getValue().getCardType().equals("Monstruo")){
                userDeckMonster += "Card Name: " + entry.getValue().getCardName() + "\n";
            } else if (entry.getValue().getCardType().equals("Hechizo")){
                userDeckSpell += "Card Name: " + entry.getValue().getCardName() + "\n";
            } else if (entry.getValue().getCardType().equals("Trampa")){
                userDeckTrap += "Card Name: " + entry.getValue().getCardName() + "\n";
            }
        }
        return userDeckMonster + userDeckSpell + userDeckTrap;
    }
}
