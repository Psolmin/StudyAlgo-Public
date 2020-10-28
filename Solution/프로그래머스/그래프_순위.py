from collections import defaultdict, deque

def strongCount(start, graph_dict, n):
    visit = [False]*n
    count = 0
    
    q = deque([start])
    visit[start] = True

    while q:
        node = q.popleft()
        
        for nextNode in graph_dict[node]:
            if visit[nextNode] == False:
                q.append(nextNode)
                visit[nextNode] = True
                count += 1
    
    return count

def solution(n, results):
    answer = 0
    graph_dict = defaultdict(list)
    for w, l in results:
        graph_dict[l-1].append(w-1)
    
    count = [0]*n
    for i in range(n):
        count[i] = strongCount(i, graph_dict, n)
    
    count = sorted(count, reverse=True)
    
    temp = n-1
    for i in range(n):
        if count[i] == temp:
            answer += 1
            temp -= 1
    return answer

n = 5
results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
print(solution(n, results))