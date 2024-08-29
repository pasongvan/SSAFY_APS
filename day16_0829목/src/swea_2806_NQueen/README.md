1차원 정수 배열 queen
인덱스: 열위치, 원소: 행위치

method(int row)

기저조건
row == N
경우의 수 추가

재귀부분
for (col: 0 ~ N-1)
queen[col]==0이고
queen의 나머지 원소 |인덱스-col|!=원소 이면
queen[col] = row
method(row+1)
queen[col] = 0