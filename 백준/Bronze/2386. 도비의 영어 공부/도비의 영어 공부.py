while True :
  n = input()
  if n == '#' :
    break
  v = n[0]
  data = n[2::]
  ans = data.count(v) + data.count(v.upper())
  print(v, ans)