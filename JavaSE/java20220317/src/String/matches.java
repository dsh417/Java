package String;

public class matches {
    public static void main(StringShch[] args) {

//        098-13311323
        String s="098-13311323";
        String reges="\\d{3,4}-\\d{8}";
        System.out.println(s.matches(reges));
    }
}
