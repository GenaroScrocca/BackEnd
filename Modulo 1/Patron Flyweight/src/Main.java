public class Main {
    public static void main(String[]args){
        Bosque bosque= new Bosque();
        for(int i=0; i<500_000; i++){
            bosque.plantarArbol(i,i,"Frutal");
            bosque.plantarArbol(i,i,"Ornamental");
        }
        System.out.println("Arboles plantados: 1.000.000");
        Runtime runtime= Runtime.getRuntime();
        System.out.println("Memoria usada: "+(runtime.totalMemory() - runtime.freeMemory()) / (1024*1024) + "mb");

        //Para mostrar algunos arboles
        bosque.mostrar();
    }
}
