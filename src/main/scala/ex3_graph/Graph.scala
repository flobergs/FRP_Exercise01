package ex3_graph

import scala.collection.immutable.Queue

trait Graph {
  type N  // abstract type for nodes

  val nodes: Set[N]
  val edges: Set[(N, N)]

  def successors(node: N) : Set[N] = edges
    .filter((start, _) => start == node)
    .map((_, end) => end)

  def computeDists(start: N): Map[N, Int] = {
    def distsRec(queue: Queue[N], result: Map[N, Int], visited : Set[N]) : Map[N, Int] = {
      if (queue.isEmpty) result
      else {
        val node = queue.head
        val nextVisited = visited + node
        val successorList = successors(node)
          .removedAll(visited)
          .removedAll(queue)
        val nextQueue = queue.tail.appendedAll(successorList)
        val nextResult = result ++ successorList.map(successor => (successor, result(node)+1))
        distsRec(nextQueue, nextResult, nextVisited)
      }
    }

    distsRec(Queue(start), Map(start -> 0), Set())
  }

  def computePaths(start: N): Map[N, List[N]] = {
    def pathsRec(queue: Queue[N], result: Map[N, List[N]], visited : Set[N]) : Map[N, List[N]] = {
      if (queue.isEmpty) result
      else {
        val node = queue.head
        val nextVisited = visited + node
        val successorList = successors(node)
          .removedAll(visited)
          .removedAll(queue)
        val nextQueue = queue.tail.appendedAll(successorList)
        val nextResult = result ++ successorList.map(successor => (successor, successor :: result(node)))
        pathsRec(nextQueue, nextResult, nextVisited)
      }
    }

    pathsRec(Queue(start), Map(start -> List()), Set())
      .map((k,v) => (k, v.reverse))
  }

  def computeValues[R](start: N, startValue: R, resultFn: (N, R) => R): Map[N, R] = ???

  def computeDistsG(start: N): Map[N, Int] = ???


  def computePathsG(start: N): Map[N, List[N]] = ???

}

trait IntGraph extends Graph {
  type N = Int
}


