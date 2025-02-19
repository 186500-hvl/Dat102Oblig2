package dat102;
public class Main {
   public static void main(String[] args) {
       String test1 = "{ [ ( ) ] }"; 
       String test2 = "{ [ ( ) }";   
       System.out.println("Test 1: " + ParentesSjekker.sjekkParenteser(test1));
       System.out.println("Test 2: " + ParentesSjekker.sjekkParenteser(test2));
   }
}

