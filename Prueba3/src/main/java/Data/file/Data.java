package Data.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private final File file;
    private final String type;
    private boolean fileExists;

    public Data(String type){
        this.type = type;
        this.file = new File("DataFiles/"+type+".csv");
        if (!this.file.isFile()){
            try {
                this.fileExists = this.file.createNewFile();
            }catch (IOException e){
                e.printStackTrace(System.out);
            }
        }else
            this.fileExists = true;
    }
    public static String listToCSV(List<String>list){
        String csv ="";
        for (String param: list){
            csv = csv.concat(param).concat(",");
        }
        csv = csv.substring(0,csv.length()-1);
        return csv;
    }

    public List<String>getData(){
        List<String> data = new ArrayList<>();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(this.file));
            do {
                line = fileReader.readLine();
                if (line!=null){
                    data.add(line);
                }
            }while (line!=null);
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace(System.out);
        }
        return data;
    }

    public boolean insertLine(String line){
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(this.file, true));
            salida.println(line);
            salida.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateLine(String oldLine,String newLine){
        boolean update = false;
        String currLine, trimmedLine;
        File tempFile = new File("_"+this.type+".csv");
        try {
            if (!tempFile.isFile()){
                tempFile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true));
            while ((currLine = reader.readLine())!=null){
                trimmedLine = currLine.trim();
                if (trimmedLine.equals(oldLine)){
                    writer.write(newLine+System.getProperty("line.separator"));
                    update = true;
                }else
                    writer.write(currLine+System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        final boolean d = this.file.delete();
        final boolean b = tempFile.renameTo(this.file);
        return update && d && b;
    }

    public boolean deleteLine(String line) {
        boolean deleted = false;
        File tempFile = new File("_" + this.type + ".csv");
        String currLine, trimmedLine;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            while ((currLine = reader.readLine()) != null) {
                trimmedLine = currLine.trim();
                if (!trimmedLine.equals(line))
                    writer.write(currLine + System.getProperty("line.separator"));
                else
                    deleted = true;
            }
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final boolean d = this.file.delete();
        final boolean b = tempFile.renameTo(this.file);
        return b && d && deleted;
    }

    public void clearFile() {
        boolean cleared = false;
        File tempFile = new File("_TEMP_EMPTYFILE.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
            writer.close();
            cleared = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        final boolean d = this.file.delete();
        final boolean b = tempFile.renameTo(this.file);
    }

    public boolean isFileExists() {
        return fileExists;
    }

    public String getFilePath() {
        try {
            return this.file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
