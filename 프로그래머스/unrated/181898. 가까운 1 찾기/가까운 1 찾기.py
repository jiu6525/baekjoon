def solution(arr, idx):
    arr = "".join(map(str, arr[idx:]))
    answer = arr.find("1") + idx if arr.find("1") !=-1 else -1
    return answer