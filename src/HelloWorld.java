public class HelloWorld {
    static int i,j;

    public static void main(String[] args) {
        HelloWorld value = new HelloWorld();
        i = 10;
        j = 10;
        triple(value, j);
        System.out.println(" " + j); // выведет 30 10
    }

    public static void triple (HelloWorld x,int j){
        i = i * 3;
        j = j * 3;
    }
}
