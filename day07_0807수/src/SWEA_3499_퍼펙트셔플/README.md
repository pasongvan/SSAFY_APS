큐에 담음

0. 홀수이면 poll, (len/2)번 offer(poll)
큐가 빌 때까지 반복
1. poll
2. offer(poll()) len/2-1 ~ 0번
3. poll
4. offer(poll()) len/2-1 ~ 0번

<큐 구현>
offer
poll

6개 => 2 2 1 1
7개 => 3 2 2 1
8개 => 3 3 2 2 1 1


1 4 2 5 3 6

2: 1 / 4 5 6 2 3 
2: 1 4 / 2 3 5 6 
1: 1 4 2 / 5 6 3 
1: 1 4 2 5 / 3 6
0: 