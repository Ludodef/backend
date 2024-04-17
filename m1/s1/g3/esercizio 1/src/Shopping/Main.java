package Shopping;

public class Main {
    public static void main(String[] args){
        Articolo articolo = new Articolo();
        articolo.setCodiceArticolo("1325hgvjfd");
        articolo.setDisponibili(13);
        articolo.setPrezzo(345);
        articolo.setDescrizione("bellissimo articolo");

        Cliente ludovica = new Cliente();
        ludovica.setCodiceCliente("24395g");
        ludovica.setCognome("De Fazio");
        ludovica.setNome("Ludovica");
        ludovica.setEmail("defazioludovica@gmail.com");
        ludovica.setIscrizione("28/04/1995");



    }
}
