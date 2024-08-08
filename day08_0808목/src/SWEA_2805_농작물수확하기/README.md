설계: 11:36 ~ 11:51
코딩: 11:51 ~ 12:17

1. 위 절반 더하기
    for (int i=0; i<=N/2; i++)
        for (int j=N/2-i; j<=N/2+i; j++)
            += arr[i][j]

2. 아래 절반 더하기
    for (int i=N/2+1; i<N; i++) {
        for (int j=N/2 - (N-1-i); j<=N/2 + (N-1-i); j++) {
            += arr[i][j]
        }
    }