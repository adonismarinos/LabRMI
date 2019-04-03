package std29006;
import std29006.Oraculo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que implementa a interface do objeto distribu´ıdo
 */
public class Xablau implements Oraculo{
    private ArrayList<Integer> senhas = new ArrayList<Integer>();
    private ArrayList<String> nomes = new ArrayList<String>();
    @Override
    public int gerarSenha(String nome) throws RemoteException {
        if (nomes.contains(nome)==false){
            if (this.senhas.size() < 4){
                nomes.add(nome);
                Random rand = new Random();
                int sorteio = rand.nextInt(101);
                while(senhas.contains(sorteio)==true){
                    sorteio = rand.nextInt(101);
                }
                senhas.add(sorteio);
                return sorteio;
            }else
                return -1;
        }
        return -1;
    }

    @Override
    public String gerarResultado() throws RemoteException {
        if(senhas.size() != 4){
            return "SemVencedor";
        }
        int aux = 1;
        String nome = nomes.get(0);
        int aux1 = senhas.get(0);

        while(aux<senhas.size()){
            int aux2 = senhas.get(aux);
            if(aux1<aux2){
                aux1 = aux2;
                nome = nomes.get(aux);
            }
            aux++;
        }
        String result = nome + " " + aux1;
        return result;
    }
}
