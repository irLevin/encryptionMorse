package Core;

public abstract class MethodEncryptDecrypt {
    protected String name;

    public MethodEncryptDecrypt(String name){
        this.name = name;
    }
    abstract public String encrypt(String message);
    abstract public String decrypt(String message);
}
