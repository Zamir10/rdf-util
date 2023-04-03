import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Change {
    public static void main(String[] args) throws IOException {
        int counter = 1000;
        for (int i = counter; i <= 9000; i += 1000) {

            String json = Files.readString(Path.of("/home/zamir/Documents/Juzo-Prod/cosy/creative-work/" + i + ".jsonld"));
            JSONArray jsonArray = new JSONArray(json);
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);

                JSONObject relatedCreativeWork = jsonObject.optJSONArray("relatedCreativeWork").getJSONObject(0);
                JSONObject documentPage = jsonObject.optJSONArray("documentPage").optJSONObject(0);

                if (relatedCreativeWork != null) {
                    JSONObject rcwId = new JSONObject();
                    rcwId.put("@id", relatedCreativeWork.get("parent"));
                    relatedCreativeWork.remove("parent");
                    relatedCreativeWork.put("parent", rcwId);
                }

                if (documentPage != null) {
                    JSONObject dpId = new JSONObject();
                    dpId.put("@id", documentPage.get("parent"));
                    documentPage.remove("parent");
                    documentPage.put("parent", dpId);
                }
//                System.out.println(relatedCreativeWork);
//                System.out.println(jsonObject.toString(2));
            }
//            System.out.println(jsonArray.getJSONObject(0).toString(2));
            Files.write(Path.of("/home/zamir/Documents/Juzo-Prod/cosy/processed/" + i + ".json"), jsonArray.toString().getBytes());
        }
    }
}
