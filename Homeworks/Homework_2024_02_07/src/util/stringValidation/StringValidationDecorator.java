package util.stringValidation;
public class StringValidationDecorator implements StringValidator{
    private final StringValidator validator;
    public StringValidationDecorator(StringValidator v){
        validator = v;
    }
    @Override
    public boolean isValid(String s) {
        return validator.isValid(s);
    }
}
