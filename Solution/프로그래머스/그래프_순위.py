from collections import defaultdict, deque

def personCount(start, graph_dict, n):
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
    win = defaultdict(list)
    lose = defaultdict(list)
    for w, l in results:
        win[w-1].append(l-1)
        lose[l-1].append(w-1)
    
    totalCount = [0]*n
    for i in range(n):
        totalCount[i] = personCount(i, win, n) + personCount(i, lose, n)
    print(totalCount)
    
    return totalCount.count(n-1)

n = 5
results = [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
print(solution(n, results))