public class Road {
    private final int length;


    public Road() {
        this.length = 3;
    }

    public static void main(String[] args) {
        Road road = new Road();
    }

    public int getLength(){
        return this.length;
    }
}
