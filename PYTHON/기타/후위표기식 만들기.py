import sys
# sys.stdin = open('3. 후위표기식 만들기\in4.txt', 'r')

'''
# 문제
후위표기식 만들기

# 입력
3+5*2/(7-2)

# 출력
352*72-/+
'''

def solution(x):
    answer = []
    opStack = []
    for c in x:
        if c.isdecimal():
            answer.append(c)
        else:
            if opStack:
                if c == '(':
                    opStack.append(c)
                elif c == ')':
                    while opStack and opStack[-1] != '(':
                        answer.append(opStack.pop())
                    opStack.pop()
                elif c == '+' or c == '-':
                    while opStack and opStack[-1] != '(':
                        answer.append(opStack.pop())
                    opStack.append(c)
                elif c == '*' or c == '/':
                    if opStack[-1] == '+' or opStack[-1] == '-':
                        opStack.append(c)
                    else:
                        if opStack[-1] != '(':
                            answer.append(opStack.pop())
                        opStack.append(c)
            else:
                opStack.append(c)
    while opStack:
        if opStack[-1] != '(':
            answer.append(opStack.pop())
    return ''.join(answer)

x = input()
print(solution(x))

'''
( ) > * / > + -

'''