name = input()
L = name.count("L")
O = name.count("O")
V = name.count("V")
E = name.count("E")

ans = []

for i in range(int(input())):
    team = input()
    L1 = L + team.count("L")
    O1 = O + team.count("O")
    V1 = V + team.count("V")
    E1 = E + team.count("E")
    res = ((L1+O1) * (L1+V1) * (L1+E1) * (O1+V1) * (O1+E1) * (V1+E1)) % 100
    ans.append([team,res])

ans.sort(key=lambda x:(-x[1],x[0]))

print(ans[0][0])
