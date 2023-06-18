def change(lst,num):
    arr = []
    for i in range(len(lst)):
        a = bin(lst[i])[2:]
        ia = len(a)
        if ia < num:
            arr.append("0" * (num-ia) + a)
        else:
            arr.append(a)
    return arr

def solution(n, arr1, arr2):
    arr1,arr2 = change(arr1,n), change(arr2,n)
    arr = []
    for i in range(n):
        r = ""
        for j in range(n):
            r += str(int(arr1[i][j]) or int(arr2[i][j]))
        arr.append(r)
        
    for i in range(len(arr)):
        arr[i] = arr[i].replace('1','#')
        arr[i] = arr[i].replace('0',' ')

    return arr