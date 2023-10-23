package interview.preparation.self.asked.company.question;

import interview.preparation.self.asked.company.model.Node;

public interface ISynechron {

    public Node createList(Node node, int a[]);

    public void display(Node node);

    public Node createCycle(Node node);

    public void detectRemoveCycle(Node node);

    public Node nthNodeFromLast(Node node, int n);
}
