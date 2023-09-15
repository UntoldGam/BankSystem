import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManagement {
    private File WriteDefaultDataToFile(String Name) throws IOException {
        FileWriter w = null;
        try {
            File UserFile = new File("src/users/"+Name+".txt");
            System.out.println("User file for " + Name + " has been created. Found at: " + UserFile.getPath());
            w = new FileWriter(UserFile);
            w.write("{\"name\":" + Name + ",\"balance\":0}");
            return (File) UserFile;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (w != null) {
                w.close();
            }
        }
        return null;
    }

    public File LocateFile(String Name) {
        File UserFile;
        try {
            UserFile = new File("src/users/"+Name+".txt");
            if (UserFile.createNewFile()) {
                return (File) WriteDefaultDataToFile(Name);
            } else {
                return UserFile;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String ReadFile(File UserFile) {
        Scanner myReader = null;
        try {
            myReader = new Scanner(UserFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                return (String) data;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (myReader != null) {
                myReader.close();
            }

        }
        return null;
    }

    public List<String> GetFileData(File file) {
        String data = ReadFile(file);// Read file and this = that;
        List<String> UserString = TurnJSONStringIntoList(data);
        return UserString;
    }

    public Boolean DeleteFile(File fileToDelete) {

        return false;
    }

    public Boolean UpdateFileData(File UserFile, List<String> NewData) {

        return false;
    }

    private static List<String> TurnJSONStringIntoList(String json) {
        List<String> values = new ArrayList<>();
        String onlyValues = getOnlyJsonValues(json);

        try {
            StringReader stringReader = new StringReader(onlyValues);
            BufferedReader bufReader = new BufferedReader(stringReader);
            String line;
            while ((line = bufReader.readLine()) != null) {
                if (line.endsWith(",")) {
                    line = line.substring(0, line.length() - 1);
                }
                if (line.startsWith("\"") && line.endsWith("\"")) {
                    line = line.substring(1, line.length() - 1);
                }

                line = line.trim();
                if (line.length() > 0) {
                    values.add(line);
                }

            }
        } catch (IOException e) {
            System.out.println("Unable to read lines in String:" + onlyValues);
        }

        return values;
    }

    private static String getOnlyJsonValues(String json) {
        json = json.replaceAll("\\{", "");
        json = json.replaceAll("}", "");
        json = json.replaceAll("\\[", "");
        json = json.replaceAll("]", "");
        json = json.replaceAll("\".*?\":", "");
        return json;
    }
}
