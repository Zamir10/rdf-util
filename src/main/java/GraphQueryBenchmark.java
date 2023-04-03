import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

public class GraphQueryBenchmark {
    public static void main(String[] args) {
        Repository repository = new HTTPRepository("https://kg.elevait.io/", "benchmark");

        repository.init();
        RepositoryConnection connection = repository.getConnection();

        String query = "SELECT * WHERE {?s ?d ?f .} LIMIT 100";

        TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, query);

        try (TupleQueryResult result = tupleQuery.evaluate()) {
            while (result.hasNext()) {
                BindingSet bindings = result.next();

                System.out.println(bindings);
            }
        } catch (QueryEvaluationException queryEvaluationException) {
            queryEvaluationException.printStackTrace();
        }
    }
}
