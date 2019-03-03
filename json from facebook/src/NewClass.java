
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import javax.json.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1h21-14-7-2018
 */
public class NewClass {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("in.txt");
                JsonReader rdr = Json.createReader(is)) {
            FileWriter fw = new FileWriter(new File("out.txt"));
            JsonObject obj = rdr.readObject();
            JsonObject set = (JsonObject) obj.get("photos");
             JsonArray photos = set.getJsonArray("photo");
            JsonArray data = set.getJsonArray("data");
         // JsonArray data = obj.getJsonArray("data");

            String s;
            int i = 0;

            for (JsonObject ee : data.getValuesAs(JsonObject.class)) {
                //System.out.println(ee);
                JsonArray im = ee.getJsonArray("images");
                JsonObject img = im.getJsonObject(4);
                JsonValue src = img.get("source");
                //System.out.println(im.getJsonObject(0));
                s = "[img]"
                        + src.toString().substring(1,
                                src.toString().length() - 1)
                        + "[/img]";
                System.out.println(s);
                fw.write(s);
                fw.write(System.lineSeparator());
                i++;
            }
            /*  for (JsonObject images : data.getValuesAs(JsonObject.class)) {
                /*  for (Object image : images) {
                    System.out.println(image);
                }*/

            //JsonArray d = images.getJsonArray("");
            //   System.out.println(d);
            //  System.out.println(images.getClass());
            /*  i++;
            }
             */
            System.out.println("NewClass.main() " + i);
            /*     for (JsonObject photo : photos.getValuesAs(JsonObject.class)) {
               /* s = photo.getString("title") + " [img]https://farm" + photo.getInt("farm");
                s += ".staticflickr.com/" + photo.getString("server");
                s += "/" + photo.getString("id");
                s += "_" + photo.getString("secret") + "_c.jpg[/img]";

                System.out.println(s);
                fw.write(s);
                fw.write(System.lineSeparator());*/
            //    }
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
