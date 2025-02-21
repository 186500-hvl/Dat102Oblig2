package dat102;

public class Main {
    public static void main(String[] args) {
        String[] testCases = {
            "{ [ ( ) ] }",  
            "{ [ ( ) }",    
            "[ ( ) ] }",    
            "{ [ ( ] ) }",  
            "( [ { } ] )",  
            "((()))",        
            "({[)]}",        
            "{ [ ( a + b ) * c ] }", 
            "",              
            "{",             
            "}"              
        };

        for (String test : testCases) {
            System.out.println("Test: " + test + " -> " + ParentesSjekker.sjekkParenteser(test));
        }
    }
}
