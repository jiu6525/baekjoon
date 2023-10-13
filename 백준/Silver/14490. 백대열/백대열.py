from math import gcd

word = list(map(int,input().split(":")))

g = gcd(word[0],word[1])
print(f'{word[0]//g}:{word[1]//g}')