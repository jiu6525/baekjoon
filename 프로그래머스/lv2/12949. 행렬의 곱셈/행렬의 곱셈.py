import numpy as np

def solution(arr1, arr2):
    return [[sum(a*b for a,b in zip(X_row,Y_col)) for Y_col in zip(*arr2)] for X_row in arr1]
