class Leecode22GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            return result;
        }
        helper(result, new StringBuilder(),n , 0, 0);
        return result;
    }
    private void helper(List<String> result, StringBuilder sb, int n, int l, int r) {
        //     System.out.println(l + " " + r);

        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(result, sb, n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            helper(result, sb, n, l, r  + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}