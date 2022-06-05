package pkg2102_project3;

import java.util.LinkedList;

public class Graph<Type> {

    LinkedList<Edge>[] linkedList;
    int vertices;
    boolean bool;

    Graph(int vertices) {
        this.vertices = vertices;
        linkedList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            linkedList[i] = new LinkedList<>();
        }
    }

    public void addCharacter(int index, Type source, Type target, int weight) {
        Edge edge = new Edge(index, source, target, weight);
        linkedList[index].addFirst(edge);
    }

    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).weight > 0) {
                    System.out.println("Source: {" + list.get(j).source + "} Target: {" + list.get(j).target + "} Weight: {" + list.get(j).weight + "}");
                }
            }
        }
        System.out.println("****************************************");
    }

    public void ClosestCharacters(Type character, int threshold) {
        System.out.println("\nClosest Characters Less Than {" + threshold + "} Units To {" + character + "}\n");
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character)) {
                    if (threshold > list.get(j).weight) {
                        System.out.println("{" + list.get(j).target + "} With {" + list.get(j).weight + "} Units");
                        bool = true;
                    }
                }
            }
        }
        DisplayError();
    }

    public void FartherCharacters(Type character, int threshold) {
        System.out.println("\nFarther Characters More Than {" + threshold + "} Units To {" + character + "}\n");
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character)) {
                    if (threshold < list.get(j).weight) {
                        System.out.println("{" + list.get(j).target + "} With {" + list.get(j).weight + "} Units");
                        bool = true;
                    }
                }
            }
        }
        DisplayError();
    }

    public void isConnected(Type character1, Type character2) {
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1) && list.get(j).target.equals(character2)) {
                    if (list.get(j).weight > 0) {
                        System.out.println("\n{" + character1 + "} And {" + character2 + "} Are Connected With {" + list.get(j).weight + "} Unit");
                        bool = true;
                    }
                }
            }
        }
        ConnectionError(character1, character2);
    }

    public void ShortestPath(Type character1, Type character2) {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1)) {
                    if (list.get(j).weight > 0) {
                       
                    }
                }
            }
        }
    }

    public void deleteCharactersConnection(Type character1, Type character2) {
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1) && list.get(j).target.equals(character2)) {
                    if (list.get(j).weight > 0) {
                        list.get(j).weight = -1;
                        System.out.println("\nThe Connection Between {" + list.get(j).source + "} and {" + list.get(j).target + "} Is Deleted\n");
                        bool = true;
                    }
                }
            }
        }
        ConnectionError(character1, character2);
    }

    public void changeWeight(Type character1, Type character2, int newWeigth) {
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1) && list.get(j).target.equals(character2)) {
                    if (list.get(j).weight > 0) {
                        list.get(j).weight = newWeigth;
                        System.out.println("\nThe New Weigth Between Of {" + list.get(j).source + "} and {" + list.get(j).target + "} Is Setted To {" + newWeigth + "}");
                        bool = true;
                    }
                }
            }
        }
        ConnectionError(character1, character2);
    }

    public void numberOfCharacterGroup(Type character1) {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1)) {
                    if (list.get(j).weight > 0) {
                        System.out.println("Source: {" + list.get(j).source + "} Target: {" + list.get(j).target + "} Weight: {" + list.get(j).weight + "}");
                        numberOfCharacterGroup((Type) list.get(j).target);
                    }
                }
            }
        }
    }

    public void lowestWeights() {
        int minWeighted = 100;
        bool = false;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).weight < minWeighted) {
                    minWeighted = list.get(j).weight;
                }
            }
        }
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).weight == minWeighted) {
                    System.out.println("The Weight Between {" + list.get(j).source + "} and {" + list.get(j).target + "} Is {" + list.get(j).weight + "}");
                    bool = true;
                }
            }
        }
        System.out.println("****************************************");
    }

    public void greatestWeights() {
        int maxWeighted = 0;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).weight > maxWeighted) {
                    maxWeighted = list.get(j).weight;
                }
            }
        }
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).weight == maxWeighted) {
                    System.out.println("The Weight Between {" + list.get(j).source + "} and {" + list.get(j).target + "} Is {" + list.get(j).weight + "}");
                }
            }
        }
        System.out.println("****************************************");
    }

    public void degreeOfCharacter(Type character1) {
        int degree = 0;
        for (int i = 0; i < vertices; i++) {
            LinkedList<Edge> list = linkedList[i];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).source.equals(character1)) {
                    if (list.get(j).weight > 0) {
                        degree++;
                    }
                }
            }
        }
        System.out.println("\nThe Degree Of {" + character1 + "} Is {" + degree + "}\n"
                + "****************************************");
    }

    private void DisplayError() {
        if (!bool) {
            System.out.println("\nThere Are No Characters To Display !");
        }
        System.out.println("****************************************");
    }

    private void ConnectionError(Type character1, Type character2) {
        if (!bool) {
            System.out.println("\nThere Are No Connection Between {" + character1 + "} and {" + character2 + "} !");
        }
        System.out.println("****************************************");
    }
}
