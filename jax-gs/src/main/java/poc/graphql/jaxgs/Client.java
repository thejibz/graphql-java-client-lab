package poc.graphql.jaxgs;

import poc.graphql.jaxgs.core.Document;

public class Client {
    private Document document;

    public Client withDocument(Document doc) {
        this.document = doc;
        return this;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
