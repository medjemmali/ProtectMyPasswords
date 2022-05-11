package protectmypasswords.controller;

class Singleton {
    // Static variable reference of single_instance
    // of type Singleton
    private static Singleton single_instance = null;

    // Declaring a variable of type String
    private static String masterPassword;

    Singleton(String password)
    {
        masterPassword = password;
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

}