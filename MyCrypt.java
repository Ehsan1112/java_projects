public class Main {

    public static void main(String[] args) {
        //String salt = "/o1K8XFfWLgm.XPgP6Y.c";
        StringBuffer salt = new StringBuffer("/o1K8XFfWLgm.XPgP6Y.c");

        String pass = myCrypt("123456", salt);
        System.out.println(pass);

    }

    public static String myCrypt(String pass, StringBuffer salt) {

        if (salt == null) {
            StringBuffer Allowed_Chars = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789./");
            int Chars_Len = 63;
            int Salt_Length = 21;
            salt = null;


            for (int i = 0; i < Salt_Length; i++) {
                salt.append(Allowed_Chars.charAt((int) Math.random() * Salt_Length));
            }
        }
        String bcrypt_salt = "$6$rounds=5000$" + salt + "$";
        String hashed_password = Crypt.crypt(pass, bcrypt_salt);
        return hashed_password;
    }
}
