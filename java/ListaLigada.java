import javax.sound.midi.Soundbank;

public class ListaLigada implements EstruturaDeDados{
    private No inicio;

    // public void removeInicio (){
    //     if (inicio != null)
    //         inicio = inicio.getProximo();
    // }

    // public void removeFim (){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getProximo() == null){
    //         inicio = null;
    //     }
    //     removeFim(inicio);
    // }

    // public void removeFim (No n){
    //     No proximo = n.getProximo();
    //     if (proximo.getProximo() == null){
    //         n.setProximo(null);
    //         return;
    //     } else{
    //         removeFim(proximo);
    //     }
    // }

    // public void insereInicio (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     No n = new No(valor);
    //     n.setProximo(inicio);
    //     inicio = n;

    // }

    // public void insereFim (int valor){
    //     if(inicio == null){
    //         inicio = new No(valor);
    //         return;
    //     }
    //     insere(inicio, valor);
    // }

    // public boolean procura (int valor){
    //     if (inicio == null){
    //         return false;
    //     } else {
    //         return procura(inicio, valor);
    //     }
    // }

    // public boolean procura (No n, int valor){
    //     if (n.getValor() == valor){
    //         return true;
    //     } else if (n.getProximo() == null){
    //         return false;
    //     } else {
    //         return procura(n.getProximo(), valor);
    //     }
    // }
    // public void insere (No n, int valor){
    //     if (n.getProximo() == null){
    //         No novo = new No(valor);
    //         n.setProximo(novo);
    //     } else {
    //         insere(n.getProximo(), valor);
    //     }
    // }

    // public void remover(int valor){
    //     if (inicio == null){
    //         return;
    //     }
    //     if (inicio.getValor() == valor){
    //         inicio = inicio.getProximo();
    //         return;
    //     }
    //     remover(inicio, valor);
    // }

    // public void remover(No n, int valor){
    //     No proximo = n.getProximo();
    //     if (proximo == null){
    //         return;
    //     }
    //     if (proximo.getValor() == valor){
    //         n.setProximo(proximo.getProximo());
    //     } else{
    //         remover(proximo, valor);
    //     }
    // }


    
    public boolean insert(int chave) {
        if(inicio == null){
            inicio = new No(chave);
            inicio.setProximo(null);
            
            return true;
        }
        else if(inicio.getProximo()== null){
            No no = new No(chave);
            inicio.setProximo(no);
            no.setProximo(null);
            return true;
        }
        else{
            insertTwo(chave,inicio);
            return true;
        }
    }
    public boolean insertTwo(int chave,No novo){
        if(novo.getProximo() == null){
            No a = new No(chave);
            novo.setProximo(a);
            return true;
        }
        else{
            insertTwo(chave, novo.getProximo());
        }
        return false;
    }

    @Override
    public boolean delete(int chave) {
        if(inicio.getValor() == chave){
            inicio = inicio.getProximo();
            return true;
        }
        else{
            return deleteTwo(inicio, chave);
        }
        
    }
    public boolean deleteTwo(No novo , int chave){
        No delet = novo.getProximo();
        if(delet.getValor() == chave)
        {
            novo.setProximo(delet.getProximo());
            return true;
            
        }
        else{
             return deleteTwo(novo.getProximo(), chave);
        }
    }

    @Override
    public boolean search(int chave) {
        if(inicio ==null){
            return false;
        }
        else if(inicio.getValor() == chave){
            return true;
        }
        else{
            return searchDuo(inicio.getProximo(), chave);
        }
        
        
    }
    public boolean searchDuo(No proximo, int chave){
        if(proximo.getValor() == chave){
            return true;
        }
        else if(proximo.getProximo() == null){
            return false;
        }
        else{
            return searchDuo(proximo.getProximo(), chave);
        }
        
        

    }

    @Override
    public int minimum() {
        if(inicio == null){
            return 0;
        }
        else{
            int min = inicio.getValor();
            if(inicio.getProximo()==null){
                return min;
            }
            else{
               return minimumTwo(inicio,min);
            } 
        }
    }
    public int minimumTwo(No comparador, int min){
        int save = min;
        if(comparador.getProximo()==null){
            return min;}
        if(comparador.getProximo().getValor()<min){
           save = comparador.getProximo().getValor();
        }
           return minimumTwo(comparador.getProximo(), save);
    
    }

    @Override
    public int maximum() {
        if(inicio == null){
            return 0;
        }
        
        else{
            int max = inicio.getValor();
            if(inicio.getProximo()==null){
                return max;
            }
            else{
               return maxiDuo(inicio,max);
            } 
        }
    }
    public int maxiDuo(No comparador, int max){
        int saveMax = max;
        if(comparador.getProximo()==null){
            return max;}
        if(comparador.getProximo().getValor()>max){
           saveMax = comparador.getProximo().getValor();
        }
           return maxiDuo(comparador.getProximo(), saveMax);
    }

    @Override
    public int sucessor(int chave) {
        
        if(inicio.getValor()== chave){
            return inicio.getProximo().getValor();
        }
        else{
            return sucessorDuo(inicio, chave);
            
        }

    }
    public int sucessorDuo(No sucess,int chave){
        if(sucess.getProximo().getValor() == chave){
            return  sucess.getProximo().getValor();
        }
        return sucessorDuo(sucess.getProximo(), chave);
    }

    @Override
    public int prodessor(int chave) {
        if(inicio.getValor() == chave){
            return -1;
        }
        else if(inicio.getProximo().getValor()==chave){
            return -1;
        }
        else{
            return prodessorDuo(inicio.getProximo(), chave);
        }
    }
    public int prodessorDuo(No prod, int chave){
        int save = prod.getValor();
        if(prod.getProximo().getValor()==chave){
            return save;
        }
        else{
            return prodessorDuo(prod.getProximo(), chave);
        }
    }
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        System.out.println(lista.insert(10));  
        System.out.println(lista.insert(11)); 
        System.out.println(lista.insert(12));  
        System.out.println(lista.search(12));    
        // System.out.println(lista.delete(11)); 
        // System.out.println(lista.search(11));
        System.out.println(lista.maximum()); 
        System.out.println(lista.minimum());   
        System.out.println(lista.sucessor(10));
        System.out.println(lista.prodessor(12));
        lista.insert(5);
        System.out.println(lista.minimum());
        


    }
}
