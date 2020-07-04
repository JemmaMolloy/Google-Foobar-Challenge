#running-with-bunnies

import copy
def solution(times, times_limit):
    # Your code here
    g = Graph(times)   

    if g.V < 3: 
        return []
    
    maxFreedBunnies = set([])
    if g.BellmanFordCompleteSource():
        
        for freedBunnies in g.get_paths(0, g.V-1, times_limit):
            
            maxLen = len(maxFreedBunnies)
            freedLen = len(freedBunnies)
            if maxLen < freedLen or (maxLen == freedLen and sum(maxFreedBunnies) > sum(freedBunnies)):
                maxFreedBunnies = freedBunnies            
    else:
        return range(g.V-2)

    return map(lambda x: x-1, sorted(maxFreedBunnies - set([0, g.V-1])))  
    
class Graph:

    def __init__(self, square_matrix):
        self.graph = square_matrix
        self.V = len(square_matrix)  

        self.INF = float("Inf")
        self.distances = [[self.INF for _ in xrange(self.V)] for _ in xrange(self.V)]
    
    def BellmanFord(self, src):        
        self.distances[src][src] = 0
                
        for _ in xrange(self.V - 1):  
            for u in xrange(self.V):
                for v in xrange(self.V):
                    if self.distances[src][u] != self.INF and self.distances[src][u] + self.graph[u][v] < self.distances[src][v]:
                        self.distances[src][v] = self.distances[src][u] + self.graph[u][v]
                        
         
        for u in xrange(self.V):
            for v in xrange(self.V):
                if self.distances[src][u] != self.INF and self.distances[src][u] + self.graph[u][v] < self.distances[src][v]:
                    return False

        return True

    def BellmanFordCompleteSource(self):
        for v in xrange(self.V):
            if not self.BellmanFord(v):                
                return False
        return True
        

    def get_paths(self, start, goal, time):
        stack = [(start, [start], time, 
                [[i] for i in range(self.V)])]
        childVertexes = set(range(self.V))
        while stack:
            (vertex, path, remainTime, cycleFactorVertexes) = stack.pop()
            for next in childVertexes - set(cycleFactorVertexes[vertex]):
                timeToNext = self.distances[vertex][next]
                timeToGoalFromNext = self.distances[next][goal]
                timeToBackFromNext = self.distances[next][vertex]
                nextCycleFactorVertexes = copy.deepcopy(cycleFactorVertexes) 

                if timeToBackFromNext + timeToNext == 0:
                    nextCycleFactorVertexes[vertex].append(next)
                    nextCycleFactorVertexes[next].append(vertex)

                if (0 <= remainTime - timeToNext - timeToGoalFromNext): 
                    nextPath = path + [next]           
                    nextRemainTime = remainTime - timeToNext                       
                    stack.append((next, nextPath, nextRemainTime, nextCycleFactorVertexes))          
                    if next == goal:
                        freedBunnies = set(nextPath)
                        yield freedBunnies  
                        if len(freedBunnies) == self.V: 
                            return
