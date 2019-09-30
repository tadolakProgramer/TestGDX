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
import static game.MyGdxGame.FILE_SPACE_SHIP;

public class MakeXML {

    public static void createPlayerFile(String playerName) throws IOException {

            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("player");
            root.addElement("Name").addText(playerName);
            root.addElement("money").addText("5001");
            root.addElement("planetCount").addText("0");

            // Pretty print the document to System.out
            writeXML(document, FILE_PLAYER);

    }

    public static void  createSpaceship() throws IOException {

            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("ship");
            root.addElement("Name").addText("Tado-045");
            root.addElement("pos").addAttribute("x", "4965.5073")
                    .addAttribute("y", "5799.1235");
            root.addElement("target").addAttribute("x", "5013.96")
                    .addAttribute("y", "5764.547");
            for (int i = 0; i < 13; i++) {
                Element slot = root.addElement("SLOT" + i);
                slot.addElement("ModuleType").addText("Empty");
                slot.addElement("Name").addText("");
                slot.addElement("Capacity").addText("0");
                slot.addElement("Cost").addText("0");
                slot.addElement("BaseFailureRate").addText("0");
                Element fill = slot.addElement("Fill");
            }
            Element slot = root.addElement("SLOT13");
            slot.addElement("ModuleType").addText("SPACE_SHIP_ENGINE");
            slot.addElement("Name").addText("Silnik");
            slot.addElement("Capacity").addText("4");
            slot.addElement("Cost").addText("600");
            slot.addElement("BaseFailureRate").addText("10");
            Element fill = slot.addElement("Fill");

            // print the document to System.out

            writeXML(document, FILE_SPACE_SHIP);
        }

    public static void writeXML(Document document, String fileName) {

        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter(new FileWriter(Gdx.files.getLocalStoragePath() + fileName), format);
            writer.write(document);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
