class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        
        StringBuilder ans = new StringBuilder();
        for(String word: words) {
            if(word.charAt(0)=='$' && word.length()!=1) {
                boolean check = false;
                for(int i=1; i<word.length(); i++) {
                    if(word.charAt(i)=='$' || !Character.isDigit(word.charAt(i))) {
                        check = true;
                        break;
                    }   
                }
                
                if(check == false) {
                    double val = Double.parseDouble(word.substring(1));
                    double disc = (double)discount/100;
                    double newVal = val - (val*disc);
                    word = "$"+String.format("%.2f", newVal);
                }
            }
            
            ans.append(word+" ");   
        }
        
        String finalAns = ans.toString().trim();
        
        return finalAns;
    }
}