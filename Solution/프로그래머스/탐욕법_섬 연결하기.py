def solution(n, costs):
    answer = 0
    MAX = float('inf')
    ans = [MAX] * n
    graph = [[MAX]*n for _ in range(n)]
    
    for i in range(n):
        graph[i][i] = 0

    for c in costs:
        graph[c[0]][c[1]] = c[2]
        graph[c[1]][c[0]] = c[2]
    
    ans[0] = 0
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if ans[j] > graph[i][j]:
                ans[j] = graph[i][j]
            
    print(ans)
    return sum(ans)
n = 4
costs = [[0,1,1], [0,2,2], [1,2,5], [1,3,1], [2,3,8]]
print(solution(n, costs))