package std29006;
import std29006.Oraculo;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Classe que implementa a interface do objeto distribu´ıdo
 */
public class Xablau implements Oraculo{
    private int[] senhas = new int[4];
    private String[] nomes = new String[4];
    private int counter = 0;
    @Override
    public int gerarSenha(String nome) throws RemoteException {
        if (counter != 4){
            nomes[counter] = nome;
            Random rand = new Random();
            senhas[counter] = rand.nextInt(101);
            counter ++;
        }else
           return -1;
    }

    @Override
    public String gerarResultado() throws RemoteException {
        if(counter!=4){
            return "SemVencedor";
        }
        int aux = 1;
        int aux1 = senhas[0];
        int aux2 = senhas[1];

        while(aux==counter){
            if(aux1>aux2){
                counter++;
                aux2=senhas[counter];
            }else{

            }

        }
        return null;
    }
}
