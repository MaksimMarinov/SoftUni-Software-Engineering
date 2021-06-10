package mathOperation;

public class MathOperation {
    public int add(int f, int s){
        return f+s;
    }
    public int add(int f, int s, int t){
        return add(f,s)+t;
    }
    public int add(int first, int s, int t, int fourth){
        return add(add(first,s), t)+fourth;
    }
}
