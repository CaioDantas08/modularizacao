public abstract class CriptografiaBase {

    protected String chave;

    public CriptografiaBase(String chave) {
        this.chave = chave;
    }

    public abstract String aplicar(String texto) throws Exception;

}