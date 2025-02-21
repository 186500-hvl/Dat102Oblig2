package dat102;

public class ParentesSjekker {
    public static boolean sjekkParenteser(String s) {
        LenketStabel<Character> stabel = new LenketStabel<>();

        for (char c : s.toCharArray()) {
            if (erStartParentes(c)) {
                stabel.push(c);
            } else if (erSluttParentes(c)) {
                if (stabel.erTom() || !erParentesPar(stabel.pop(), c)) {
                    return false;
                }
            }
        }
        return stabel.erTom();
    }

    public static boolean erStartParentes(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public static boolean erSluttParentes(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static boolean erParentesPar(char start, char slutt) {
        return (start == '(' && slutt == ')') ||
               (start == '[' && slutt == ']') ||
               (start == '{' && slutt == '}');
    }
}

class LenketStabel<T> {
    private Node topNode;

    public LenketStabel() {
        topNode = null;
    }

    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    public T pop() {
        if (erTom()) {
            throw new RuntimeException("Stabelen er tom");
        }
        T top = topNode.data;
        topNode = topNode.neste;
        return top;
    }

    public boolean erTom() {
        return topNode == null;
    }

    private class Node {
        private T data;
        private Node neste;

        private Node(T data, Node neste) {
            this.data = data;
            this.neste = neste;
        }
    }
}
