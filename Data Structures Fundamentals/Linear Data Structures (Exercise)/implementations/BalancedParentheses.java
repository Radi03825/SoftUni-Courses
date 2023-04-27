package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        if (this.parentheses == null || this.parentheses.length() == 0 || this.parentheses.length() % 2 != 0) {
            return false;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        int middle = this.parentheses.length() / 2;

        for (int i = 0; i < middle; i++) {
            stack.push(this.parentheses.charAt(i));
        }

        for (int i = middle; i < this.parentheses.length(); i++) {
            queue.offer(this.parentheses.charAt(i));
        }

        for (int i = 0; i < middle; i++) {
            Character stackElement = stack.pop();
            Character queueElement = queue.poll();

            switch (stackElement) {
                case '(':
                    if (queueElement != ')') {
                        return false;
                    }
                    break;
                case '{':
                    if (queueElement != '}') {
                        return false;
                    }
                    break;
                case '[':
                    if (queueElement != ']') {
                        return false;
                    }
                    break;
                case ' ':
                    if (queueElement != ' ') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }

        return true;
    }
}
