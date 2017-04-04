import java.util.*;
public class Question1{
	public static void main(String[] args){
		System.out.println(Q2("hello"));
	} 
  
// This part is for question 1.
	public static int Q1(String word){
	       int sum = 0;
           for(int index=0;index<word.length();index++){
                  sum = sum+CheckTypeNumber(word.charAt(index));
           }  
    return sum;
}

//This function returns how many times users should type for one letter.
    public static int CheckTypeNumber(char letter){
    	char[] arr1 = {'a','d','g','j','m','p','t','w','A','D','G','J','M','P','T','W'};
    	char[] arr2 = {'b','e','h','k','n','q','u','x','B','E','H','K','N','Q','U','X'};
    	char[] arr3 = {'c','f','i','l','o','r','v','y','C','F','I','L','O','R','V','Y'};
    	char[] arr4 = {'s','z','S','Z'};

    	for(int i=0;i<16;i++){
    		if(arr1[i]==letter){return 1;}
    		if(arr2[i]==letter){return 2;}
    		if(arr3[i]==letter){return 3;}
    	}
    	return 4;
    }

}



