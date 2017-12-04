package sample;

/**
 * Created by biropo on 02.12.17.
 */
public enum option {

    Admin, Guest;

    private option(){}

    public String value () {
        return name();
    }
    public static option fromvalue(String val){
        return valueOf(val);
    }
}
