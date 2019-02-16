public class Constants {
    public static final String fileName = "./src/main/resources/cars.json";

    public static final String helpString = "Write \"/help\" for more information";

    public static final String smthIsWrongString = "Something is wrong with your command";

    public static final String moreInformationString =
            "Available commands: /add, /change [number], /delete [number], exit \n" +
                    "Existing flags for adding and changing: -year -model -manufacturer -class -body\n" +
                    "Year should be a number, all fields should contain just one word";

    public static final String year = "-year";
    public static final String model = "-model";
    public static final String manufacturer = "-manufacturer";
    public static final String theClass = "-class";
    public static final String body = "-body";

    public static final String add = "/add";
    public static final String change = "/change";
    public static final String delete = "/delete";
    public static final String help = "/help";
    public static final String exit = "/exit";
}
