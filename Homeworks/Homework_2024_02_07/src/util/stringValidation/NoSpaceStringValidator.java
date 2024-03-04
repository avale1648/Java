package util.stringValidation;
public class NoSpaceStringValidator implements StringValidator{
    public NoSpaceStringValidator() {}
    //Здесь используется нижнее подчеркивание вместо пробела потому что класс CommandManager делит строку комманды по пробелам.
    @Override
    public boolean isValid(String s){
        return !s.contains("_");
    }
}
