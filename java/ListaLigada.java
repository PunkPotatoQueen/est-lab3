public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    public void removeInicio (){
        if (inicio != null)
            inicio = inicio.getProximo();
    }

    public void removeFim (){
        if (inicio == null){
            return;
        }
        if (inicio.getProximo() == null){
            inicio = null;
        }
        removeFim(inicio);
    }

    public void removeFim (No n){
        No proximo = n.getProximo();
        if (proximo.getProximo() == null){
            n.setProximo(null);
            return;
        } else{
            removeFim(proximo);
        }
    }

    public void insereInicio (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        No n = new No(valor);
        n.setProximo(inicio);
        inicio = n;

    }

    public void insereFim (int valor){
        if(inicio == null){
            inicio = new No(valor);
            return;
        }
        insere(inicio, valor);
    }

    public boolean procura (int valor){
        if (inicio == null){
            return false;
        } else {
            return procura(inicio, valor);
        }
    }

    public boolean procura (No n, int valor){
        if (n.getValor() == valor){
            return true;
        } else if (n.getProximo() == null){
            return false;
        } else {
            return procura(n.getProximo(), valor);
        }
    }
    public void insere (No n, int valor){
        if (n.getProximo() == null){
            No novo = new No(valor);
            n.setProximo(novo);
        } else {
            insere(n.getProximo(), valor);
        }
    }

    public void remover(int valor){
        if (inicio == null){
            return;
        }
        if (inicio.getValor() == valor){
            inicio = inicio.getProximo();
            return;
        }
        remover(inicio, valor);
    }

    public void remover(No n, int valor){
        No proximo = n.getProximo();
        if (proximo == null){
            return;
        }
        if (proximo.getValor() == valor){
            n.setProximo(proximo.getProximo());
        } else{
            remover(proximo, valor);
        }
    }

    public static void main(String[] args) {
        ListaLigada a = new ListaLigada();
        a.insert(0);
        a.insert(2); 
        a.insert(3); 
        a.insert(7); 
        System.out.println(a.search(3));
        a.delete(3);
        System.out.println(a.search(3));
    }


    @Override
    public boolean insert(int chave) {
        if (inicio == null){
            inicio = new No(chave);
        }
        else{
            insere(inicio, chave);
        }
        return true;
    }

    @Override
    public boolean delete(int chave) {
        if (inicio == null){
            return false;
        }
        if (inicio.getValor()==chave){
            remover(chave);
            return true;
        }
    }

    @Override
    public boolean search(int chave) {
        if (procura(chave)==true){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int minimum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int maximum() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int sucessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        // TODO Auto-generated method stub
        return 0;
    }
}
