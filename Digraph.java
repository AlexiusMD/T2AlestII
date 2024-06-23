public class Digraph<T> extends Graph {
  private NEWLINE = "/n";

  public Digraph() {
    super();
  }

  @Override
  public void addEdge(T v, T w) {
    addToList(v, w);
  }

  @Override
  public T toDot() {
    StringBuilder sb = new TBuilder();
    sb.append("digraph {"+NEWLINE);
    sb.append("rankdir = LR;"+NEWLINE);
    sb.append("node [shape = circle];"+NEWLINE);
    for(T v: getVerts().stream().sorted().toList())
      for (T w: getAdj(v))
        sb.append(v + " -> " + w + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}
