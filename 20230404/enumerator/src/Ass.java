public class Ass {
    private int a;
    public Ass (int a){
        this.a = a;
    }
    public static void print(String a){
        System.out.println(a);
    }
    public int square(){
        return a*a;
    }
    public int getA(){
        return a;
    }
    public void setA(int a){
        this.a = a;
    }
}
