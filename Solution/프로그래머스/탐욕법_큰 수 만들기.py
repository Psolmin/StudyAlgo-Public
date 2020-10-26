def solution(number, k):
    stack = []
    for n in number:
        while stack and k > 0 and stack[-1] < n:
            stack.pop()
            k-=1
        stack.append(n)
    return ''.join(stack[:-k]) if k>0 else ''.join(stack)
       


number = "1924"
k = 2
print(solution(number, k))