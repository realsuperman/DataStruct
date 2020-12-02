import Chapter4.Gqueue;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        Graph a = new Graph("A");
        Graph b = new Graph("B");
        Graph c = new Graph("C");
        Graph d = new Graph("D");

        a.add(c);
        a.add(b);
        b.add(d);

        dfs(a);
        bfs(a);
    }

    public static void dfs(Graph graph){
        System.out.println(graph.str+" ");
        if(graph.child.size()>0){
            for(int i=0;i<graph.child.size();i++)
                dfs(graph.child.get(i));
        }
    }

    public static void bfs(Graph graph){
        Gqueue queue = new Gqueue(10);
        queue.enque(graph);

        while(!queue.isEmpty()){
            Graph g = (Graph) queue.deque();
            for(int i=0;i<g.child.size();i++)
                queue.enque(g.child.get(i));
            System.out.println(g.str);
        }
    }
}

class Graph{
    String str;
    List<Graph> child=new ArrayList<>();

    public Graph(String str){
        this.str = str;
    }

    public void add(Graph graph){
        child.add(graph);
    }
}

