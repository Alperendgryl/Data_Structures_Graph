package pkg2102_project3;

public class Edge<Type> {

    int index;
    Type source;
    Type target;
    int weight;

    public Edge(int index, Type source, Type target, int weight) {
        this.index = index;
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}
