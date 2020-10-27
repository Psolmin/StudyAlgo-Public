'''
# 문제
N명을 1번부터 N번째까지 동그랗게 있을 때,
K번째마다 제거시킴. 제거 후 다음이 다시 1번째로 기록하여 계속 반복할 때
마지막 남은 번호를 출력

# 입력
8 3

# 출력
7

# 설명
3 6 1 5 2 8 4 // '7'
'''

from collections import deque
import sys
# sys.stdin = open('5. 공주구하기\in1.txt', 'r')

def solution(n, k):
    num_que = deque([i for i in range(1, n+1)])
    count = 0
    while len(num_que) > 1:
        count+=1
        if count != k:
            num_que.append(num_que.popleft())
        else:
            num_que.popleft()
            count = 0
        
    return num_que[0]

n, k = map(int, input().split())
print(solution(n, k))

'''
1 2 3 4 5 6 7 8

1 2 4 5 7 8

2 4 
'''