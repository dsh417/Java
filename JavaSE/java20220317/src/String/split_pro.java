package String;

public class split_pro {
    public static String joins(String[] s){
        StringBuffer sb=new StringBuffer();
        sb.append("\"");
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            if(i!=s.length-1){
                sb.append(",");
            }else {
                sb.append("\"");
            }
        }
        return sb.toString();
    }

}
