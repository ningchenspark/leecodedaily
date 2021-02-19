class Leetcode320GeneralizedAbbr {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(word.toCharArray(), result, new StringBuilder(), 0 , 0);
        return result;
    }
    private void dfs(char[] chars, List<String> result, StringBuilder sb, int idx , int num) {
        int len = sb.length();
        if (idx == chars.length) {
            if (num != 0) {
                sb.append(num);
            }
            result.add(sb.toString());

        } else {

            dfs(chars, result, sb,  idx + 1, num + 1);               // abbr c[i]

            if(num != 0){
                sb.append(num);
            }
            // not abbr c[i]
            dfs(chars, result, sb.append(chars[idx]), idx + 1, 0);
        }
        sb.setLength(len);

    }
}