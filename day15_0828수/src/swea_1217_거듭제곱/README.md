재귀 함수(N, M)

기저조건
M<=1 이면 return 1

짝수일 때
tmp = 함수(N, M/2)
return tmp * tmp

홀수일 때
tmp = 함수(N, M/2)
return tmp * tmp * N