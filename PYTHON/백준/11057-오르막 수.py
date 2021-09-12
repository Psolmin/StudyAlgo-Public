def solution(N):
    dp = [[0 for _ in range(10)] for _ in range(N)]
    dp[0] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

    for n in range(1, N):
        for i in range(10):
            for j in range(i, 10):
                dp[n][i] += dp[n-1][j]

    return sum(dp[N-2]) % 10007 if N != 1 else 10

N = int(input())
print(solution(N))