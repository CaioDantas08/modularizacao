import java.io.*;
public class RunningOptions {

    private String metodo = "";
    private String chave = "";
    private String  data = "";

    public void setMetodo(char metodo) {
        this.metodo += metodo;
    }

    public void setChave(char chave) {
        this.chave += chave;
    }

    public void setData(char data) {
        this.data += data;
    }

    public RunningOptions(){
    }

    public String getMetodo() {
        return metodo;
    }

    public String getChave() {
        return chave;
    }

    public String getData() {
        return data;
    }
    
}
