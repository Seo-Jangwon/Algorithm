N = int(input())
dp = [0] * 31  # N의 최대값이 30이므로
dp[0] = 1
dp[2] = 3

for i in range(4, N+1, 2):
    dp[i] = dp[i-2] * 3
    for j in range(4, i, 2):
        dp[i] += dp[i-j] * 2
    dp[i] += 2  # 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양으로 끝나는 경우

if N % 2 == 0:
    print(dp[N])
else:
    print(0)  # 홀수일 경우 3×N 크기의 벽을 완전히 채울 수 없음