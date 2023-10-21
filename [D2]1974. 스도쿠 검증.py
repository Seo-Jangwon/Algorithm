# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
      아래의 구문은 input.txt 를 read only 형식으로 연 후,
      앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
      여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
      아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.

      따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
      아래 구문을 사용하기 위해서는 import sys가 필요합니다.

      단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
#import sys
#sys.stdin = open("input.txt", "r")
def sdk(index,arr):
  global count
  temp=[0]*9
  arrcheck=0
  cal=0
  row=0

  for i in range(index[0],index[0]+3):
    for j in range(index[1],index[1]+3):
      temp[arr[i][j]-1]+=1
  if temp[0]!=1 or temp[1]!=1 or temp[2]!=1 or temp[3]!=1 or temp[4]!=1 or temp[5]!=1 or temp[6]!=1 or temp[7]!=1 or temp[8]!=1:
    return  0

  for i in range(index[0],(index[0]+3)):
    temp_row=[0]*9
    for j in range(9):
      temp_row[arr[i][j]-1]+=1
    for k in range(9):
      if temp_row[k]!=1:
        return 0

  for j in range(index[1],index[1]+3):
    temp_cal=[0]*9
    for i in range(9):      
      temp_cal[arr[i][j]-1]+=1
    for k in range(9):
      if temp_cal[k]!=1:
        return 0
  return  1

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
  arr=[list(map(int,input().split())) for _ in range(9)]
  ans=0
  check=[0]*9
  index=[[0,0],[0,3],[0,6],[3,0],[3,3],[3,6],[6,0],[6,3],[6,6]]
  for n in range(9):
    check[n]=sdk(index[n],arr)
  if check[0]==check[1]==check[2]==check[3]==check[4]==check[5]==check[6]==check[7]==check[8]==1:
    ans=1
  print("#"+str(tc)+" "+str(ans))