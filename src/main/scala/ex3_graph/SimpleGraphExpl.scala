package ex3_graph

object SimpleGraph extends IntGraph with App {
//  val nodes: Set[N] = Set(1, 2, 3)
  val edges: Set[(N, N)] = Set((1, 2), (1, 3), (2, 4), (3, 4))
  val nodes: Set[N] = edges.map((n, _) => n) ++ edges.map((_, n) => n)

  println(s"edges= $edges")
  println(s"nodes= $nodes")

  assert(successors(1) == Set(2, 3))
  assert(successors(2) == Set(4))
  assert(successors(3) == Set(4))

  val dists = computeDists(1)
  println(dists)

  val paths = computePaths(1)
  println(paths)

  val distsG = computeDistsG(1)
  println(distsG)

  val pathsG = computePathsG(1)
  println(pathsG)

}

