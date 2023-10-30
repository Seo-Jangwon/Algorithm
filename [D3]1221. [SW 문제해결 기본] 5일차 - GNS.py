def arr():
  one=''
  two=''
  three=''
  four=''
  five=''
  six=''
  seven=''
  eight=''
  nine=''
  zero=''
  for i in lists:
      if i=='ONE':
          one+=i+" "
      elif i=='TWO':
          two+=i+" "
      elif i=='THR':
          three+=i+" "
      elif i=='FOR':
          four+=i+" "
      elif i=='FIV':
          five+=i+" "
      elif i=='SIX':
          six+=i+" "
      elif i=='SVN':
          seven+=i+" "
      elif i=='EGT':
          eight+=i+" "
      elif i=='NIN':
          nine+=i+" "
      elif i=='ZRO':
          zero+=i+" "
  ans=zero+one+two+three+four+five+six+seven+eight+nine
  return ans

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
  inp=input()
  lists=input().split(' ')
  ans=arr()
  print("#"+str(tc)+" "+ans)