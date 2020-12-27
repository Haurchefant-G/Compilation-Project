int printf(char *format, ...);

char input[] = "abcba";
int length_t = 5;

int main() {
    int first = 0, last = length_t - 1;
    int isPalindromic = 1;
    while (first < last) {
        if (input[first] == input[last]) {
            ++first;
            --last;
        } else {
            isPalindromic = 0;
            break;
        }
    }

    if (isPalindromic) {
        printf("The given text is palindromic.\n");
    } else {
        printf("The given text is not palindromic.\n");
    }
}