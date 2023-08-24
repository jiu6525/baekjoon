def solution(arr):
        answer = -1
        parr = arr.copy()
        while 1:
            answer += 1
            for i in range(len(arr)):
                if arr[i] >= 50 and arr[i]%2==0:
                    arr[i] = arr[i]//2
                elif arr[i] <50 and arr[i]%2==1:
                    arr[i] = arr[i]*2+1
            if parr==arr:
                return answer
            else:
                parr = arr.copy()