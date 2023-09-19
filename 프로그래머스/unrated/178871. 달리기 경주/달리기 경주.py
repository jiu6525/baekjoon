def solution(players, callings):
    players_rank = {j:i for i,j in enumerate(players)}
    # {'mumu': 0, 'soe': 1, 'poe': 2, 'kai': 3, 'mine': 4}

    for call in callings:
        idx = players_rank[call]
        players_rank[call] -= 1
        players_rank[players[idx-1]] += 1
        players[idx-1],players[idx] = players[idx],players[idx-1]

    return players