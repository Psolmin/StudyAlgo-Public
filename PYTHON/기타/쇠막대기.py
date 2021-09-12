import sys
# sys.stdin = open('2. 쇠막대기\in2.txt', 'rt')
'''
# 문제
쇠막대기를 레이저로 절단, 절단된 쇠막대기 조각의 총 개수를 출력

규칙
• 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 
놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
• 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
• 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다. 

1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반 
 드시 레이저를 표현한다.
2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다. 

# 입력 
()(((()())(())()))(())

# 출력
17
'''

def solution(x):
    answer = 0
    x = x.replace('()', 'l')
    stack = []
    ''' 카운트 없이 할 수 있었음 '''
    # count = 0
    for c in x:
        if c == '(':
            stack.append(0)
            # count += 1
        elif c == ')':
            # count -= 1
            answer += 1
            # answer += stack[count] + 1
            stack.pop()
        elif c == 'l':
            # for i in range(count):
            #     stack[i] += 1
            answer += len(stack)
        
    return answer

x = input()
print(solution(x))

''' 

() (  (  ( () () )  ( () )  ()  )  )     (())
          1  1  1    1  1  1  1

'''