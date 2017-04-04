// This part is for question 2
public class Questoin2{
    public static String Q2(String word){
    	String sum="";
    	for(int index=0;index<word.length();index++){
    		sum = sum + CheckNumber(word.charAt(index));
    	}
    	return sum;
    }

//This function returns the number user need to press for one letter
public static int CheckNumber(char letter){
         
         char[] arr2 = {'a','b','c','A','B','C'};
         char[] arr3 = {'d','e','f','D','E','F'};
         char[] arr4 = {'g','h','i','G','H','I'};
         char[] arr5 = {'j','k','l','J','K','L'};
         char[] arr6 = {'m','n','o','M','N','O'};
         char[] arr7 = {'p','q','r','s','P','Q','R','S'};
         char[] arr8 = {'t','u','v','T','U','V'};
         char[] arr9 = {'w','x','y','z','W','X','Y','Z'};
         
         for(int i=0;i<8;i++){
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
}