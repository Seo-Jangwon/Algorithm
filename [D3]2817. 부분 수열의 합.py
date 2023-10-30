def sums(idx, sm):
  global ans
  if idx==N:
    if sm==K:
      ans+=1
    return
  sums(idx+1,sm+A[idx])
  sums(idx+1,sm)



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
  ans=0
  N, K = map(int, input().split())
  A = list(map(int, input().split()))
  sums(0,0)
  print("#"+str(tc)+" "+ str(ans))