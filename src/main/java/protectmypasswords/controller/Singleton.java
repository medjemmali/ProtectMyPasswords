package protectmypasswords.controller;

class Singleton {
    // Static variable reference of single_instance
    // of type Singleton
    private static Singleton single_instance = null;
    private int changes = 0;
    // Declaring a variable of type String
    private static String masterPassword;

    Singleton(String password)
    {

        if(changes == 0){
            masterPassword = password;
            changes++;
        }
;
    }

    public static String getMasterPassword() {
        return masterPassword;
    }

    public static String getFilename()
    {
        if (masterPassword == null)
            masterPassword = "";

        return masterPassword.substring(0,15) + ".bin";
    }

    public static boolean changeMasterPassword(String oldPassword, String newPassword){

        if(oldPassword.equals(masterPassword)){
            masterPassword = newPassword;
            return true;
        }

        return false;
    }
}