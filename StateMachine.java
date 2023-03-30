public class StateMachine {
    public static boolean DFA(String s) { // deterministic finite automaton
        int state = 1;
        int pos = 0;
        while(pos < s.length() && state != -1) {
            char c = s.charAt(pos++);
            switch(state) {
                case 1:
                    if(c == 'a') state = 2;
                    else if (c == 'b') state = 4;
                    else state = -1;
                    break;
                case 2:
                    if(c == 'a') state = 1;
                    else if (c == 'b') state = 3;
                    else state = -1;
                    break;
                case 3:
                    if(c == 'a') state = 4;
                    else if (c == 'b') state = 2;
                    else state = -1;
                    break;
                case 4:
                    if(c == 'a') state = 3;
                    else if (c == 'b') state = 1;
                    else state = -1;
                    break;
            }
        }
        return state == 1 || state == 3;
    }

    public static void main(String[] args) {
            System.out.println(DFA("abababababab"));
    }
}