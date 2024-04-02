
public class p {
    public static class Bool {
        boolean b;
        public Bool (boolean b) {
            this.b = b;
        }
    }

    static void f(Bool b) {
        Bool b2 = new Bool(true);
        b = b2;
    }
    
    public static void main(String[] args) {
        
        Bool b = new Bool(false);

        f(b);

        System.out.println(b.b);
        
    }

}
