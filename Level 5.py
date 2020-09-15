#dsorderly-escape

from collections import Counter

def factorial(b):
    if b == 0:
        return 1
    else:
        return b * factorial(b-1)

def gcd(x, y):
    gcd = 1
    
    if x % y == 0:
        return y
    
    for k in range(int(y / 2), 0, -1):
        if x % k == 0 and y % k == 0:
            gcd = k
            break  
    return gcd
    
def cycle_count(c, n):
    cc=factorial(n)
    for a, b in Counter(c).items():
        cc//=(a**b)*factorial(b)
    return cc        

def cycle_partitions(n, i=1):
    yield [n]
    for i in range(i, n//2 + 1):
        for p in cycle_partitions(n-i, i):
            yield [i] + p

def solution(w, h, s):    
    grid=0
    for cpw in cycle_partitions(w):
        for cph in cycle_partitions(h):            
            m=cycle_count(cpw, w)*cycle_count(cph, h)
            grid+=m*(s**sum([sum([gcd(i, j) for i in cpw]) for j in cph]))
              
    return str(grid//(factorial(w)*factorial(h)))
