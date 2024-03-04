package util.stringValidation;
public class OrStringValidator implements StringValidator {
    private final String CONDITION_1;
    private final String CONDITION_2;
    public OrStringValidator(String c1, String c2){
        if(c1.isEmpty())
            throw new IllegalArgumentException("condition1");
        if(c2.isEmpty())
            throw new IllegalArgumentException("condition2");
        CONDITION_1 = c1;
        CONDITION_2 = c2;
    }
    @Override
    public boolean isValid(String s){
        return s.contains(CONDITION_1) || s.contains(CONDITION_2);
    }
}
