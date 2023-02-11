public class No{
    private int valor;
    private No proximo;

    public No(int valor) {
        this.valor = valor;
        proximo = null;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No chave) {
        proximo = chave;
    }

    public int getValor() {
        return valor;
    }
}