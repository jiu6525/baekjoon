def solution(num_list):
    on = int("".join(map(str,[i for i in num_list if i%2==0])) )
    en = int("".join(map(str,[i for i in num_list if i%2!=0])) )
    return on+en
    