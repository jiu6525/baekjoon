def solution(board, moves):
    board = list(map(list,zip(*board)))

# [[0, 0, 0, 4, 3], [0, 0, 2, 2, 5], [0, 1, 5, 4, 1], [0, 0, 0, 4, 3], [0, 3, 1, 2, 1]]
    s = []
    answer = 0
    for i in moves:
        for j in range(len(board)):
            doll = board[i-1][j]
            if doll:
                if not s:
                    s.append(doll)
                elif s[-1] == doll:
                    s.pop()
                    answer += 2
                else:
                    s.append(doll)
                board[i-1][j] = 0
                break

    return answer