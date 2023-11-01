def dfs(idx,cal,scr):
    global ans
    if cal> L:
        return

    if cal<=L:
        if ans<scr:
            ans=scr

    for i in range(idx+1, N+1):
        dfs(i,cal+calories[i],scr+scores[i])



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    N,L=map(int, input().split())

    scores=[0]*(N+1)#점수
    calories=[0]*(N+1)#칼로리

    visit=[0]*(N+1)#방문노드 확인
    ans=0


    for i in range(1,N+1):
        scores[i],calories[i]=map(int, input().split())

    dfs(0,0,0)#기본 칼로리와 점수: 0

    print("#"+str(tc)+" "+str(ans))
