/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */
    abstract class Node {
        public abstract int evaluate();
    }

    class ExpressionTree extends Node {
        String expression;
        ExpressionTree left, right;

        public ExpressionTree(String expression) {
            this.expression = expression;
            left = null;
            right = null;
        }

        @Override
        public int evaluate() {
            // leaf node : number
            if (left == null && right == null) return Integer.parseInt(expression);

            // inorder
            int leftVal = left == null ? 0 : left.evaluate();
            int rightVal = right == null ? 0 : right.evaluate();

            int ans = 0;
            if (expression.equals("+")) {
                ans = leftVal + rightVal;
            } else if (expression.equals("-")) {
                ans = leftVal - rightVal;
            } else if (expression.equals("*")) {
                ans = leftVal * rightVal;
            } else if (expression.equals("/")) {
                ans = leftVal / rightVal;
            }

            return ans;
        }
    }


    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<ExpressionTree> stack = new Stack<>();
            for (String expr : postfix) {
                if (expr.equals("+") || expr.equals("-") || expr.equals("*") || expr.equals("/")) {
                    // node1 (+,-,*,/) node2
                    ExpressionTree node2 = stack.pop();
                    ExpressionTree node1 = stack.pop();

                    ExpressionTree node = new ExpressionTree(expr);
                    node.left = node1;
                    node.right = node2;
                    stack.push(node);
                } else {
                    ExpressionTree node = new ExpressionTree(expr);
                    stack.push(node);
                }
            }

            return stack.pop();
        }
    }

/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */