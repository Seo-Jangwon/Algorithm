def dfs(n):
  global count
  if n == N:
    count += 1
    return
  for i in range(N):
    if vrow[i] == 0 and vRtL[i + n] == 0 and vLtR[n - i + N] == 0:
      vrow[i] = 1
      vRtL[i + n] = 1
      vLtR[n - i + N] = 1

      dfs(n + 1)
      vrow[i] = 0
      vRtL[i + n] = 0
      vLtR[n - i + N] = 0


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
  N = int(input())
  arr = [[0] * N] * N
  vrow = [0] * N
  vRtL = [0] * (2 * N + 1)  # 0에서 10까지 저장. 인덱스 그대로 찾기
  vLtR = [0] * (2 * N + 1)  # 5에서 -5까지 값. 저장할 때 인덱스에 5 더해서 저장
  count = 0

  dfs(0)  # 깊이 0부터
  print("#" + str(tc) + " " + str(count))
