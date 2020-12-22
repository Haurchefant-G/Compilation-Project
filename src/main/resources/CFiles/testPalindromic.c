int printf(char *format,...);

char t[1000] = "abcba";
int length_t = 5;

int main()
{
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