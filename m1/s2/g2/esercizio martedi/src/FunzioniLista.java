import java.util.*;



    public class FunzioniLista {
        public static List<Integer> generaListaCasuale(int N) {
            Random rand = new Random();
            List<Integer> lista = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                lista.add(rand.nextInt(101));
            }
            Collections.sort(lista);
            return lista;
        }

        public static List<Integer> nuovaListaInvertita(List<Integer> lista) {
            List<Integer> nuovaLista = new ArrayList<>(lista);
            Collections.reverse(nuovaLista);
            lista.addAll(nuovaLista);
            return lista;


        }

        public static void stampaPosizioni(List<Integer> lista, boolean pari) {
            System.out.println("Elementi in posizioni " + (pari? "pari" : "dispari"));
            for (int i = 0; i < lista.size(); i++) {
                if ((pari && i % 2 == 0) || (!pari && i % 2!= 0)) {
                    System.out.print(lista.get(i) + " ");
                }
            }
            System.out.println();
        }
        public static void main(String[] args){
            int N = 13;
            List<Integer> listaCasuale = generaListaCasuale(N);
            System.out.println("Lista casuale di " + N + " elementi");
            System.out.println(listaCasuale);

            List<Integer> listaInvertita = nuovaListaInvertita(new ArrayList<>(listaCasuale));
            System.out.println("Nuova lista composta dagli elementi disposti in ordine inverso:");
            System.out.println(listaInvertita);

            stampaPosizioni(listaInvertita,true);
            stampaPosizioni(listaCasuale,false);
        }
    }



