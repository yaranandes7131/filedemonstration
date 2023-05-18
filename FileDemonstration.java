//Yara Aparecida, Caio Victor, Maíze Fraga, Vanessa Correa, Ana Claudia, Adail José, Guilherme Vinicius
import java.io.File;
import javax.swing.JOptionPane;

public class FileDemonstration
{
    public static void main(String[] args) {
        String path = JOptionPane.showInputDialog(null, "entre com o caminho");
        analyzePath(path);
    }
    
    public static void analyzePath(String path) {
        File name = new File(path);
        if (name.exists()) {
            String msg = String.format(
                "%s %s\n%s\n%s\n%s\n%s %s\n%s %s\n%s %s\n%s %s\n%s",
                name.getName(), "exists",
                (name.isFile()?"is a file" : "is not a file"),
                (name.isDirectory()? "is a Directory" : "is not a directory"),
                (name.isAbsolute() ? "is absolute path":
                 "is not absolute path"), "Last modified: "+
                name.lastModified(), "Length:", name.length(),
                "Path:", name.getPath(), "Absolute path:",
                name.getAbsolutePath(),"Parent:", name.getParent());

            if(name.isDirectory()) { 
                String[] directory= name.list();
                msg += "\n\nDirectory contents:\n";
                for (String directoryName : directory) {
                    msg += "\n" + directoryName;
                }
            }
            JOptionPane.showMessageDialog(null, msg);
        } else {
           JOptionPane.showMessageDialog(null, String.format("%s %s", path, "does not exist."));
        }
    }
}
