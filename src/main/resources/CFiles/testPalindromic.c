int strlen(char* s);
int printf(char *format,...);
int scanf(char *format,...);

char t[10000];

int main()
{
    scanf("%s", t);
    int length_t = strlen(t);
    int first = 0, last = length_t - 1;
    int is_palin = 1;
    while(first < last)
    {
        if(t[first] == t[last])
        {
            ++first;
            --last;
        }else{
            is_palin = 0;
            break;
        }
    }
    if(is_palin)
    {
        printf("wow, it is palindromic!\n");
    }else{
        printf("oops, it is not palindromic!\n");
    }
}