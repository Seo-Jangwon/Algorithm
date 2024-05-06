def sol(n):
    if n % 7 == 2:
        return 1
    else:
        return 0
 
 
if __name__ == '__main__':
    n = int(input())
    print(sol(n))