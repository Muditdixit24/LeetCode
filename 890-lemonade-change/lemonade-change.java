class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five =0;
        int ten=0;
         for(int i=0;i<bills.length;i++){
           int result= bills[i];
           if(result==5){
            five++;
           }
           else if(result==10){
            if(five==0){
                return false;
            }
            five--;
            ten++;
           }
           else{
            if(ten>0 && five>0){
               ten--;
               five--;
            }
            else if(five>=3){
                five-=3;
            }
            else{
                return false;
            }
           }
         }
         return true;
    }
}