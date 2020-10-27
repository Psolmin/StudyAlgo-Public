import sys
# sys.stdin = open('4. 후위식 연산\in2.txt', 'rt')

'''
# 문제
후위식으로 연산 수행하기

# 입력
352+*9-

# 출력
12
'''

def solution(x):
    cal_stack = []
    for c in x:
        if c.isdecimal():
            cal_stack.append(c)
        else:
            sec = cal_stack.pop()
            fir = cal_stack.pop()
            
            cal_stack.append(str(eval(fir+c+sec)))            
    return cal_stack[0] 
    
x = input()
print(solution(x))