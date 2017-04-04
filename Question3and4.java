import java.util.*;
public class Question3and4{

    public ArrayList<String> letterCombinations(String number) {
// Create an arraylist to store all possible combinations
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> preres = new ArrayList<String>();
        res.add("");
// Store all combinations to the arraylist
        for(int i=0;i<number.length();i++){
            for(String str: res)
                String letters = map.get(number.charAt(i));
                for(int j=0;j<letters.length();j++)
                    preres.add(str+letters.charAt(j));

            res = preres;
            preres = new ArrayList<String>();
        }      
        return res;
    }

// This HashMap is to relate letters to numbers
    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }
  }


    public static String Question4(String[] number) throws IOException{
        String result;
// Create a buffer to read the target file(Stored in disk D)
        FileReader fr = new FileReader("D:/WordsRTF.RTF");
        BufferedReader bufr = new BufferedReader(fr);
        String line;
 
//Find all possible combinations and store them in a string array       
        ArrayList arrList = letterCombinations(number);
       String[] wordlist =arrList.toArray(new String[arrList.size()])
    
//Add "\" at the end of each string
      for(int count =0; count<wordlist.length;count++){
          wordlist[count]= wordlist[count] +"\\";
      }

//Check the word document, try to find the words inside the documents and return them.
       while((line = bufr.readLine())!=null){
            
       
       for(int i=0;i<wordlist.length;i++){
        
       if(line.equals(wordlist[i])) {result = result + line.substring(0,line.length()-1)+",";}
       }
    
       }
       return result;
    }
    

}