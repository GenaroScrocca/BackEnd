public class Main {
    public static void main(String[] args){
        BebidaCaliente cafe= new Cafe();
        BebidaCaliente te= new Te();

        System.out.println("preparando cafe:");
        cafe.prepararReceta();

        System.out.println("\nPreparando te:");
        te.prepararReceta();
    }
}
