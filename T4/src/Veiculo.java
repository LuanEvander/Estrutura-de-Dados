import java.util.Random;

public class Veiculo implements Comparable<Veiculo>{
    private int chassi;
    private String marca;

    private static int numVeiculos = 0;
    private static Random geradorChassi = new Random();
    private static Random geradorMarca = new Random();

    public Veiculo(){
        geraChassi();
        geraMarca();
    }

    private void geraChassi(){
        if(this.numVeiculos % 2 == 0)
            this.chassi = 202050000 - geradorChassi.nextInt(50000);
        else
            this.chassi = 202050000 + geradorChassi.nextInt(50000);
        this.numVeiculos++;
    }

    private void geraMarca(){
        int c = geradorMarca.nextInt(7);
        switch(c){
            case 0: this.marca = "Ford"; break;
            case 1: this.marca = "Toyota"; break;
            case 2: this.marca = "Chevrolet"; break;
            case 3: this.marca = "Pegout"; break;
            case 4: this.marca = "Renault"; break;
            case 5: this.marca = "Mazda"; break;
            case 6: this.marca = "Lexus"; break;
            default: new Exception("ERRO NA GERAÇÃO DA MARCA");
        }
    }

    public String getMarca() {
        return this.marca;
    }
    public int getChassi() {
        return this.chassi;
    }

    public boolean isMarcaFord(){
        return (this.marca.equalsIgnoreCase("Ford"));
    }

    @Override
    public int compareTo(Veiculo v) {
        if (this.chassi > v.getChassi()) return 1;
        else if (this.chassi < v.getChassi()) return -1;
        else return 0;
    }

    @Override
    public String toString(){
        return "Veiculo chassi: "+ this.chassi + " marca: "+ this.marca;
    }

}