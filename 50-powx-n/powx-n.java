class Solution {
    public double myPow(double x, int n) {
        double result=1.0;
        long m=n;
        if(m<0){
                x=1/x;
                m=-m;
            }
        while(m>0){
            if(m%2==1){
                result=result*x;
                m=m-1;
            }
            
            else{
                m=m/2;
                x=x*x;
            }
            
        }
        return result;
        
    }
}