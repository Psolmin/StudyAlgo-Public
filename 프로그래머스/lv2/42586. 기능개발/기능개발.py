import math
def solution(progresses, speeds):
    answer = []
    complete = []
    for i in range(len(progresses)):
        day = math.ceil((100 - progresses[i]) / speeds[i])
        complete.append(day)
    
    count = 1
    i = 0
    for j in range(i + 1, len(complete)):
        if complete[i] >= complete[j]:
            count += 1
        else:
            i = j
            answer.append(count)
            count = 1
    answer.append(count)

    return answer