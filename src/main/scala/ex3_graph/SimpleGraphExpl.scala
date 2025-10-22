package ex3_graph

object SimpleGraph extends IntGraph with App {
//  val nodes: Set[N] = Set(1, 2, 3)
  val edges: Set[(N, N)] = Set((1, 2), (1, 3), (2, 4), (3, 4))
  val nodes: Set[N] = edges.map((n, _) => n) ++ edges.map((_, n) => n)

  println(s"edges= $edges")
  println(s"nodes= $nodes")

  // Task 3.1
  assert(successors(1) == Set(2, 3))
  assert(successors(2) == Set(4))
  assert(successors(3) == Set(4))

  // Task 3.2
  val dists = computeDists(1)
  println(dists)
  assert(computeDists(1) == Map((1, 0), (2, 1), (3, 1), (4, 2)))
  assert(computeDists(2) == Map((2, 0), (4, 1)))

  // Task 3.3
  val paths = computePaths(1)
  println(paths)
  assert(computePaths(1) == Map((1, List(1)), (2, List(1, 2)), (3, List(1, 3)), (4, List(1, 2, 4))))
  assert(computePaths(2) == Map((2, List(2)), (4, List(2, 4))))

  // Task 3.4
  val distsG = computeDistsG(1)
  println(distsG)
  assert(computeDistsG(1) == Map((1, 0), (2, 1), (3, 1), (4, 2)))
  assert(computeDistsG(2) == Map((2, 0), (4, 1)))

  val pathsG = computePathsG(1)
  println(pathsG)
  assert(computePathsG(1) == Map((1, List(1)), (2, List(1, 2)), (3, List(1, 3)), (4, List(1, 2, 4))))
  assert(computePathsG(2) == Map((2, List(2)), (4, List(2, 4))))

}

