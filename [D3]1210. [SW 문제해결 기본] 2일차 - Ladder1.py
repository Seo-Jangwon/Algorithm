T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
  tc = int(input())
  arr = [list(map(int, input().split())) for _ in range(100)]
  cal = 0
  row = 99
  d = 0
  for i in range(100):
    if arr[99][i] == 2:
      cal = i
  for row in range(99, 0, -1):

    if cal>0 and arr[row][cal-1]==1:
      while cal>0 and arr[row][cal-1]==1:

        cal-=1

    elif cal<99 and arr[row][cal+1]==1:
      while  cal<99 and arr[row][cal+1]==1 :

        cal+=1



  print("#"+str(tc)+" "+str(cal))