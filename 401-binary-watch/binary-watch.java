

class Solution {
    
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> result = new ArrayList<>();
        
        
        for (int hour = 0; hour <= 11; hour++) {
            
            
            for (int minute = 0; minute <= 59; minute++) {
                
                
                int hourBits = countBits(hour);
                int minuteBits = countBits(minute);
                
                int totalBits = hourBits + minuteBits;
                
                
                if (totalBits == turnedOn) {
                    
                    
                    String time;
                    
                    if (minute < 10) {
                        time = hour + ":0" + minute;
                    } else {
                        time = hour + ":" + minute;
                    }
                    
                    result.add(time);
                }
            }
        }
        
        return result;
    }
    
    
    
    private int countBits(int num) {
        
        int count = 0;
        
        while (num > 0) {
            
            if ((num & 1) == 1) {
                count++;
            }
            
            num = num >> 1;
        }
        
        return count;
    }
}
