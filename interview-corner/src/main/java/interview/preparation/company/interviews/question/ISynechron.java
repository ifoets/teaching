package interview.preparation.company.interviews.question;

import interview.preparation.company.interviews.model.Node;

public interface ISynechron {

    public Node createList(Node node, int a[]);

    public void display(Node node);

    public Node createCycle(Node node);

    public void detectRemoveCycle(Node node);

    public Node nthNodeFromLast(Node node, int n);
}
