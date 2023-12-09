import org.junit.Before;
import org.junit.Test;
import org.example.Graph;

public class testGraph {
    private Graph G;

    @Before
    public void SetUp() throws Exception {
        G = new Graph(8);
    }

    @Test
    public void BreadthFirstSearch() throws Exception{
        G.addEdge(0, 1);
        G.addEdge(1, 0);
        G.addEdge(1, 4);
        G.addEdge(4, 1);
        G.addEdge(4, 6);
        G.addEdge(6, 4);
        G.addEdge(6, 0);
        G.addEdge(0, 6);
        G.addEdge(1, 5);
        G.addEdge(5, 1);
        G.addEdge(5, 3);
        G.addEdge(3, 5);
        G.addEdge(3, 0);
        G.addEdge(0, 3);
        G.addEdge(5, 2);
        G.addEdge(2, 5);
        G.addEdge(2, 7);
        G.addEdge(7, 2);

        System.out.println("Breadth First Traversal starting from vertex 0: ");
        G.breadthFirstSearch(0);

    }

    @Test
    public void dfs() throws Exception{
        G.addEdge(0, 1);
        G.addEdge(1, 0);
        G.addEdge(1, 4);
        G.addEdge(4, 1);
        G.addEdge(4, 6);
        G.addEdge(6, 4);
        G.addEdge(6, 0);
        G.addEdge(0, 6);
        G.addEdge(1, 5);
        G.addEdge(5, 1);
        G.addEdge(5, 3);
        G.addEdge(3, 5);
        G.addEdge(3, 0);
        G.addEdge(0, 3);
        G.addEdge(5, 2);
        G.addEdge(2, 5);
        G.addEdge(2, 7);
        G.addEdge(7, 2);

        System.out.println("Depht First Traversal starting from vertex 0: ");
        G.DFS(0);

    }
}
