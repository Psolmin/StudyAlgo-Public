from collections import defaultdict, deque
def bfs(start, graph, n):
    visit = [False]*n
    dist = [0]*n
    
    q = deque([start])
    visit[start] = True
    while q:
        node = q.popleft()
        
        for next_node in graph[node]:
            if visit[next_node] == False:
                visit[next_node] = True
                q.append(next_node)
                dist[next_node] = dist[node]+1

    return dist

def solution(n, edge):
    graph_dict = defaultdict(list)
    for s, e in edge:
        s, e = s-1, e-1
        graph_dict[s].append(e)
        graph_dict[e].append(s)
    
    dist = bfs(0, graph_dict, n)
        
    return dist.count(max(dist))


# 다익스트라로 구현
'''
INF = float('inf')

def dijkstra(graph, n, start):
    visit = [False]*n
    distance = [INF]*n
    
    visit[start] = True
    for i in range(n):
        distance[i] = graph[start][i]
    
    while True:
        d = INF
        node = -1
        
        for i in range(n):
            if not visit[i] and d > distance[i]:
                d = distance[i]
                node = i
        
        if d == INF:
            break
        
        visit[node] = True
        for i in range(n):
            if visit[i]:
                continue
            if distance[i] > distance[node] + graph[node][i]:
                distance[i] = distance[node]+graph[node][i]
        
    return distance

def solution(n, edge):
    answer = 0
    graph = [[INF]*n for _ in range(n)]
    for i in range(n):
        graph[i][i] = 0
    for (s, e) in edge:
        s, e = s-1, e-1
        graph[s][e] = 1
        graph[e][s] = 1
    
    answer = dijkstra(graph, n, 0)
    
    return answer.count(max(answer))
'''


n = 6
edge = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
print(solution(n, edge))