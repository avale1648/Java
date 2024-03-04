package util.stringValidation;
public class PalindromeStringValidator implements StringValidator{
    public PalindromeStringValidator() { }
    @Override
    public boolean isValid(String s){
        var sLowerCase = s.toLowerCase();
        var reversed = "";
        var result = false;
        for(var i = sLowerCase.length() - 1; i >= 0; i--){
            reversed = reversed + sLowerCase.charAt(i);
        }
        if(sLowerCase.equals(reversed)){
            result = true;
        }
        return result;
    }
}
