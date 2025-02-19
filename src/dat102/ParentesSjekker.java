package dat102;
import java.util.Stack;
public class ParentesSjekker {
   public static boolean sjekkParenteser(String s) {
       Stack<Character> stabel = new Stack<>();
      
       for (char c : s.toCharArray()) {
           if (erStartParentes(c)) {
               stabel.push(c);
           } else if (erSluttParentes(c)) {
               if (stabel.isEmpty() || !erParentesPar(stabel.pop(), c)) {
                   return false;
               }
           }
       }
       return stabel.isEmpty();
   }
   private static boolean erStartParentes(char c) {
       return c == '(' || c == '[' || c == '{';
   }
   private static boolean erSluttParentes(char c) {
       return c == ')' || c == ']' || c == '}';
   }
   private static boolean erParentesPar(char start, char slutt) {
       return (start == '(' && slutt == ')') ||
              (start == '[' && slutt == ']') ||
              (start == '{' && slutt == '}');
   }
}
