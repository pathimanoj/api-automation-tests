package BJSSAPI.payload;

public class payLoad {

    public static String postCreateUser() {

        String createUserData = "{\n" +
                    "    \"name\": \"AutomationTester\",\n" +
                    "    \"job\": \"TestAnalyst\"\n" +
                    "}";

            return createUserData;
        }

    public static String putUpdateUser() {

        String updateUserData = "{\n" +
                "    \"name\": \"ManualTester\",\n" +
                "    \"job\": \"TestEngineer\"\n" +
                "}";

        return updateUserData;
    }

    public static String patchUpdateUser() {

        String updateUserData = "{\n" +
                "    \"name\": \"Tester\",\n" +
                "    \"job\": \"Analyst\"\n" +
                "}";

        return updateUserData;
    }
}
