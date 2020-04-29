package poc.graphql.jaxgs;

import poc.graphql.jaxgs.core.Document;

public class Client {
    private Document document;

    public Client document(Document doc) {
        this.document = doc;

        return this;
    }
}
