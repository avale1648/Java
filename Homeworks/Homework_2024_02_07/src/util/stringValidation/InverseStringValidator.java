package util.stringValidation;
public class InverseStringValidator extends AndStringValidator {
    public InverseStringValidator(String c1, String c2){
        super(c1, c2);
    }
    @Override
    public boolean isValid(String s){
        return !super.isValid(s);
    }
}
