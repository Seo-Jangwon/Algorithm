import sys
n = int(sys.stdin.readline()) #
arr=[]
for i in range(n):
    a=sys.stdin.readline().split()
    if(a[0]=='push'):
        arr.append(a[1])
    if(a[0]=='top'):
        if (len(arr) == 0):
            print(-1)
        else:
            print(arr[len(arr)-1])
    if(a[0]=='pop'):
        if(len(arr)==0):
            print(-1)
        else:
            print(arr[len(arr)-1])
            arr.pop()
    if(a[0]=='size'):
        print(len(arr))
    if(a[0]=='empty'):
        if(len(arr)==0):
            print(1)
        else:
            print(0)