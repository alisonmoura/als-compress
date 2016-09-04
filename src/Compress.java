import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alisonmoura on 03/09/16.
 */
public class Compress {

    private String stringfiedFile;
    private HuffmanMap frequencyMap = new HuffmanMap();

    public void doCompress(File file) throws CompressException{
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            stringfiedFile = sb.toString();
            doCompress();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CompressException();
        } catch (IOException e){
            e.printStackTrace();
            throw new CompressException();
        }
    }

    private void doCompress(){
        char[] chars = stringfiedFile.toCharArray();
        for(char c :chars){
            if(!frequencyMap.containsKey(c)){
                frequencyMap.put(c,1);
            }else{
                frequencyMap.put(c,frequencyMap.get(c)+1);
            }
        }

        new HuffmanTree().createTree(frequencyMap);
    }
}
