package game.HelperXML;

import com.badlogic.gdx.Gdx;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import static game.MyGdxGame.FILE_PLAYER;

public class MakeXML {

    public static void createPlayerFile(String playerName) throws IOException {

        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("player");
            root.addElement("Name").addText(playerName);
            root.addElement("money").addText("5000");
            root.addElement("planetCount").addText("0");

            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter( new FileWriter(Gdx.files.getLocalStoragePath()+FILE_PLAYER), format );
            writer.write( document );
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
