import java.util.HashMap;

/**
 * Created by alisonmoura on 04/09/16.
 */
public class HuffmanMap extends HashMap<Character, Integer> {

    public Character getMinorFrequency(){
        Integer minor = Integer.MAX_VALUE;
        Character ret = null;
        for(Character c : this.keySet()){
            if(this.get(c) < minor){
                minor = this.get(c);
                ret = c;
            }
        }
        return ret;
    }

}
