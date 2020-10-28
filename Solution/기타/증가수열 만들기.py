'''
양끝만 이용할 수 있을 때,
이를 이용해 증가수열을 만든다.
'''

from collections import deque
import sys
# sys.stdin = open('9. 증가수열 만들기\in2.txt', 'rt')

def solution(n_list):
    answer = ""
    left = 0
    right = len(n_list)-1
    last = 0
    while left <= right:
        temp = []
        if n_list[left] > last:
            temp.append((n_list[left], 'L'))
            
        if n_list[right] > last:
            temp.append((n_list[right], 'R'))
        temp.sort()
        
        if not temp:
            break
        else:
            last = temp[0][0]
            answer += temp[0][1]
            if temp[0][1] == 'R':
                right -= 1 
            elif temp[0][1] == 'L':
                left += 1
    print(len(answer))
    return answer

n = int(input())
n_list = list(map(int, input().split()))
print(solution(n_list))