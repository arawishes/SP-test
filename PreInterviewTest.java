import java.util.*;
import java.io.*;
import java.util.Scanner;

public class PreInterviewTest{
     public static void  main(String[] args)throws IOException, FileNotFoundException{

// Provide four options for the user, one for each question.
        System.out.println("Select which question you want to Run");
        System.out.println("1:Question1");
        System.out.println("2:Question2");
        System.out.println("3:Question3");
        System.out.println("4:Question4");

        Scanner in = new Scanner(System.in);
//Ask user which question to answer
        int i = in.nextInt();
        in.nextLine();
// Generate results for each question
        if(i==1){
            System.out.println("Please input the word");
            String word = in.nextLine();
            System.out.println(Question1(word));           // Generate results for question 1
        }

        if(i==2){
            System.out.println("Please input the word");
            String word = in.nextLine(); 
            System.out.println(Question2(word));           // Generate results for question 2
        }


        if(i==3){
            System.out.println("Please input the number");
            
            String number = in.nextLine();
            ArrayList arrList=Question3(number);            // The results are stored in arrList
            Iterator it1 = arrList.iterator();
            while(it1.hasNext()){
                
                System.out.println(it1.next());            // Generate results for question 3
                
            }
       
        }

        if(i==4){
            System.out.println("Please input the number");
            String number = in.nextLine();
            ArrayList arrList=Question3(number);

// Store all possible combinations from the arraylist to an array
             int index = 0;
   
            String[] arr = new String[arrList.size()];
             Iterator it2 = arrList.iterator();
           
            while(it2.hasNext()){
                arr[index] = it2.next().toString();
                index++;               
            }

// Read each line of WordsRTF.      
        FileReader fr = new FileReader("WordsRTF.RTF");
        BufferedReader bufr = new BufferedReader(fr);
        String line;
// Since all the words contained in WordsRTF end with "/", add "/"" to all combinations.
        for(int k=0;k<index;k++){
            arr[k] = arr[k] +"\\";
        }
while((line = bufr.readLine())!=null){
        
// Check if each combination is identical to some words in WordsRTF, if so, print them without "/".   
       for(int j=0;j<arrList.size();j++){
       
       if(line.equals(arr[j])) {System.out.println(line.substring(0,line.length()-1));}
             

      }
      } 
  }}
// This part is for question 1.
    public static int Question1(String word){
           int sum = 0;
           for(int index=0;index<word.length();index++){
                  sum = sum+CheckTypeNumber(word.charAt(index));
           }  
    return sum;
}

//This function returns how many times users should type for one letter.
    public static int CheckTypeNumber(char letter){
        char[] arr1 = {'a','d','g','j','m','p','t','w'};
        char[] arr2 = {'b','e','h','k','n','q','u','x'};
        char[] arr3 = {'c','f','i','l','o','r','v','y'};
        char[] arr4 = {'s','z'};
         
      letter = Character.toLowerCase(letter);

            for(int i=0;i<16;i++){
            if(arr1[i]==letter){return 1;}
            if(arr2[i]==letter){return 2;}
            if(arr3[i]==letter){return 3;}
        }
        return 4;
    }

//This part is for question 2.
       public static String Question2(String word){
        String sum="";
        for(int index=0;index<word.length();index++){
            sum = sum + CheckNumber(word.charAt(index));
        }
        return sum;
    }

//This function returns the number user need to press for one letter
public static int CheckNumber(char letter){
         
         char[] arr2 = {'a','b','c'};
         char[] arr3 = {'d','e','f'};
         char[] arr4 = {'g','h','i'};
         char[] arr5 = {'j','k','l'};
         char[] arr6 = {'m','n','o'};
         char[] arr7 = {'p','q','r','s'};
         char[] arr8 = {'t','u','v'};
         char[] arr9 = {'w','x','y','z'};

      letter = Character.toLowerCase(letter);         

         for(int i=0;i<4;i++){
            if(arr2[i]==letter){return 2;}
            if(arr3[i]==letter){return 3;}
            if(arr4[i]==letter){return 4;}
            if(arr5[i]==letter){return 5;}
            if(arr6[i]==letter){return 6;}
            if(arr7[i]==letter){return 7;}
            if(arr8[i]==letter){return 8;}
            if(arr9[i]==letter){return 9;}
         }
        
         return -1;
}
//This part is for question 3
static Map<Character,String> letterMap = new HashMap<Character,String>();
static {
    letterMap.put('1',"");
    letterMap.put('2',"abc");
    letterMap.put('3',"def");
    letterMap.put('4',"ghi");
    letterMap.put('5',"jkl");
    letterMap.put('6',"mno");
    letterMap.put('7',"pqrs");
    letterMap.put('8',"tuv");
    letterMap.put('9',"wxyz");
}

public static ArrayList<String> Question3(String number){
    char[] cs = new char[number.length()];
    ArrayList<String> res = new ArrayList<String>();
    appendNumber(number,0,cs,res);
    return res;
}

private static void appendNumber(String number,int i,char[] cs,ArrayList<String> res){
    if(i == number.length()){
        res.add(new String(cs));
        return;
    }
    String letters = letterMap.get(number.charAt(i));
    for(int j =0;j<letters.length();j++){
        cs[i]=letters.charAt(j);
        appendNumber(number,i+1,cs,res);
    }
}
}