class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> ans= new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            String q=queries[i];
            for(int j=0;j<dictionary.length;j++){
               String d=dictionary[j];
               int diff=0;
               for(int k=0;k<q.length();k++){
                if(q.charAt(k)!=d.charAt(k)){
                    diff++;
                }
                if(diff>2) break;
                 }
                 if(diff<=2){
                  ans.add(q);
                  break;
                 }
            }
        }
        return ans;
        
    }
}