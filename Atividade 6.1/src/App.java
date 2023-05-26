public class App {
    public static void main(String[] args) throws Exception {
        LDE numLista = new LDE();

        numLista.insereFim(1);
        numLista.insereFim(2);
        numLista.insereFim(3);
        numLista.insereFim(4);
        numLista.insereFim(5);
        numLista.insereFim(6);

        numLista.listarDoInicio();

        numLista.listarDoFim();

        System.out.println(numLista.tamanho());

        System.out.println(numLista.existe(3));

        numLista.remove(3);

        System.out.println(numLista.tamanho());

        System.out.println(numLista.existe(3));

    }
}
