import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class tees {
    public static void main(String[] args) {
        String encoded=new BCryptPasswordEncoder().encode("111");
        System.out.println(encoded);
    }
}
