def check():
  for i in range(n):  # 수평성분 확인
      for j in range(n-4):
          if arr[i][j]=='o' and arr[i][j+1]=='o'and arr[i][j+2]=='o'and arr[i][j+3]=='o'and arr[i][j+4]=='o':
              return 'YES'
  for i in range(n):  # 수직성분 확인
      temp = []
      for j in range(n-4):
          if (arr[j+0][i]=='o' and arr[j+1][i]=='o'and arr[j+2][i]=='o'and arr[j+3][i]=='o'and arr[j+4][i]=='o'):
              return 'YES'
  for i in range(n-4):  # 대각성분 확인
      for j in range(n-4):
          if ((arr[i+0][j+0]=='o' and arr[i+1][j+1]=='o'and arr[i+2][j+2]=='o'and arr[i+3][j+3]=='o'and arr[i+4][j+4]=='o')
                  or(arr[i+0][j+4]=='o' and arr[i+1][j+3]=='o'and arr[i+2][j+2]=='o'and arr[i+3][j+1]=='o'and arr[i+4][j+0]=='o')):
              return 'YES'
  return 'NO'

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
  n = int(input())
  arr = [list(input()) for _ in range(n)]
  ans = ''
  checkforrow=['o']*n
  checkforcal=['o']*n
  ans= check()
#    if ans==None:
#        ans='NO'
  print("#"+str(test_case)+" "+str(ans))