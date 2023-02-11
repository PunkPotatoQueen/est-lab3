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
        a.insert(-10);
        a.insert(10);
        a.insert(2); 
        a.insert(333); 
        a.insert(9); 
        a.insert(-99); 
        System.out.println(a.search(3));
        a.delete(3);
        System.out.println(a.search(3));
        System.out.println(a.minimum());
        System.out.println(a.maximum());
        System.out.println(a.sucessor(333));
        System.out.println(a.prodessor(-99));
    }


    @Override
    public boolean insert(int chave) {
        if (inicio == null){
            inicio = new No(chave);
            return true;
        }
        else{
            No a = new No(chave);
            a = inicio;
            return insert (a, chave);
        }

    }

    private boolean insert(No a, int chave) {
        if (a.getProximo()==null){
            No b = new No(chave);
            a.setProximo(b);
            return true;
        }
        else{
            insert(a.getProximo(), chave);
            return true;
        }
    }

    @Override
    public boolean delete(int chave) {
        if (search(chave)){
            if (inicio == null){
                return false;
            }
            if (inicio.getValor()==chave){
                inicio = null;
                return true;
            }
            else{
                return delete (inicio, chave);
            }
        }
        else {
            return false;
        }
    }

    private boolean delete (No a, int chave) {
        if (a.getProximo().getValor()==chave){
            a.setProximo(a.getProximo().getProximo());
            return true;
        } else{
            a = a.getProximo();
            return (delete(a, chave));
        }
    }

    @Override
    public boolean search(int chave) {
        if (inicio.getValor()==chave){
            return true;
        }
        else {
            return search(inicio.getProximo(), chave);
        }
    }

    private boolean search(No a, int chave) {
        if (a.getValor()==chave){
            return true;
        }
        else if (a.getValor() != chave && a.getProximo()==null){
            return false;
        }
        else {
            return search(a.getProximo(), chave);
        }
    }

    @Override
    public int minimum() {
        int menor = 9999;
        if (inicio.getValor()<menor && inicio.getProximo()==null){
            menor = inicio.getValor();
        }
        else {
            menor = inicio.getValor();
            menor = minimo (inicio.getProximo(), menor);
        }
        return menor;
    }

    private int minimo(No a, int menor) {
        if (a.getValor()<menor){
            menor = a.getValor();
        }
        if (a.getProximo().getProximo()==null){
            menor = ultimoMinimo (a, menor);
            return menor;
        }
        return minimo(a.getProximo(), menor);
    }

    private int ultimoMinimo(No a, int menor) {
        if (a.getProximo().getValor() < menor){
            menor = a.getProximo().getValor();
        }
        return menor;
    }

    @Override
    public int maximum() {
        int maior = -9999;
        if (inicio.getValor()>maior && inicio.getProximo()==null){
            maior = inicio.getValor();
        }
        else {
            maior = inicio.getValor();
            maior = maximo (inicio.getProximo(), maior);
        }
        return maior;
    }

    private int maximo(No a, int maior) {
        if (a.getValor()>maior){
            maior = a.getValor();
        }
        if (a.getProximo().getProximo()==null){
            maior = ultimoMaximo (a, maior);
            return maior;
        }
        return maximo(a.getProximo(), maior);
    }

    private int ultimoMaximo(No a, int maior) {
        if (a.getProximo().getValor() > maior){
            maior = a.getProximo().getValor();
        }
        return maior;
    }

    @Override
    public int sucessor(int chave) {
        int prox = 0;
        if (!search(chave)){
            return chave;
        }
        else if (inicio.getValor() == chave && inicio.getProximo()==null){
            return chave;
        }
        else if (inicio.getValor() == chave && inicio.getProximo()!=null){
            return inicio.getProximo().getValor();
        }
        else{
            prox = sucessor(inicio.getProximo(), chave);
        }
        return prox;
    }

    private int sucessor(No a, int chave) {
        if (!search(chave)){
            return chave;
        }
        else if (a.getProximo()==null && a.getValor()==chave){
            return chave;
        }
        else if (a.getValor()!=chave && a.getProximo()==null){
            return chave;
        }  
        else if (a.getValor()!= chave && a.getProximo()!=null){
            chave = sucessor (a.getProximo(), chave);
        }
        else {
            chave = a.getProximo().getValor();
        }          
        return chave;
    }

    @Override
    public int prodessor(int chave) {
        if (inicio.getValor()==chave){
            return chave;
        }
        else {
            No b = new No(chave);
            b = inicio;
            chave = antes(b, chave);
        }
        return chave;
    }

    private int antes(No a, int chave) {
        if (a.getProximo()==null && a.getValor()!=chave){
            return chave;
        }
        else if (a.getProximo().getValor()==chave){
            chave = a.getValor();
        }
        else{
            chave = antes (a.getProximo(), chave);
        }
        return chave;
    }
}
