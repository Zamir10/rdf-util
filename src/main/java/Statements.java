//import org.apache.jena.query.*;
//import org.apache.jena.rdf.model.Model;
//import org.apache.jena.rdf.model.ModelFactory;
//import org.apache.jena.riot.RDFLanguages;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Statements {
    public static void main(String[] args) throws IOException {
//        Model model = ModelFactory.createDefaultModel();
//        model.read("src/main/resources/statements/data.jsonld", RDFLanguages.strLangJSONLD);
//
//        String queryString = Files.readString(Path.of("src/main/resources/statements/query.rq"), StandardCharsets.UTF_8);
//        Query query = QueryFactory.create(queryString);
//
//        try (QueryExecution queryExecution = QueryExecution.create(query, model)) {
//            ResultSet resultSet = queryExecution.execSelect();
//            while (resultSet.hasNext()) {
//                QuerySolution solution = resultSet.nextSolution();
//                System.out.println(solution);
//            }
//        }
    }
}
