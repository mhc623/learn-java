import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:统计回文问题
 * User: Maohc
 * Date: 2020-06-03
 * Time: 19:05
 */
public class prac {
    public static boolean isHuiwen(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for(int i = 0;i <= str1.length();i++){
            StringBuilder sb =  new StringBuilder(str1);
            sb.insert(i,str2);
            if(isHuiwen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
