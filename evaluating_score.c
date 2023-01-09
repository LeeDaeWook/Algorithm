#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 
#include <stdlib.h>

int *make_sort_idx(int n)
{
    int *sort_idx;

    sort_idx = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n ; i++)
        sort_idx[i] = i;

    return (sort_idx);
}

void ft_qsort(int *score, int *sort_idx, int L, int R)
{
    int l;
    int r;
    int pivot;
    int temp;
    int temp_idx;

    l = L;
    r = R;
    pivot = score[(l + r) / 2];
    while (l <= r)
    {
        while (score[l] > pivot)
            l++;
        while (score[r] < pivot)
            r--;
        if (l <= r)
        {
            temp = score[l];
            temp_idx = sort_idx[l]; 
            score[l] = score[r];
            sort_idx[l] = sort_idx[r];
            score[r] = temp;
            sort_idx[r] = temp_idx;
            l++;
            r--;
        }
    }

    if (L < r)
        ft_qsort(score, sort_idx, L, r);
    if (l < R)
        ft_qsort(score, sort_idx, l, R);
}

void ft_print(int *score, int* sort_idx, int n)
{
    int* result;
    int i;

    i = 0;
    result = (int*)malloc(sizeof(int) * n);
    while (i < n)
    {
        if (score[i] == score[i - 1])
            result[sort_idx[i]] = result[sort_idx[i - 1]];
        else
            result[sort_idx[i]] = i + 1;
        i++;
    }

    i = 0;
    while (i < n)
        printf("%d ", result[i++]);
    printf("\n");
}

void evaluating(int n, int **score)
{
    int i;
    int* sort_idx;
        
    i = 0;
    while (i < 4)
    {
        sort_idx = make_sort_idx(n);
        ft_qsort(score[i], sort_idx, 0, n - 1);
        ft_print(score[i], sort_idx, n);
        free(sort_idx);
        sort_idx = 0;
        i++;
    }
}

int main() 
{
    int n;
    int** score;
    int i;
    int j;

    scanf("%d", &n);

    i = 0;
    score = (int**)malloc(sizeof(int*) * 4);
    while (i < 4)
        score[i++] = (int*)calloc(n, sizeof(int));

    i = 0;
    while (i < 3)
    {
        j = 0;
        while (j < n)
        {
            scanf("%d", &score[i][j]);
            score[3][j] += score[i][j];
            j++;
        }
        i++;
    }

    evaluating(n, score);

    return 0;
}