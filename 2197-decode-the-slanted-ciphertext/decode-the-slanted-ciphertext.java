class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        
        StringBuilder sb = new StringBuilder();
        
        for (int col = 0; col < cols; col++) {
            int i = 0, j = col;
            
            while (i < rows && j < cols) {
                sb.append(encodedText.charAt(i * cols + j));
                i++;
                j++;
            }
        }
        
        
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
}