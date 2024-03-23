string1 = ''
string2 = ''
s="abcdeggjhdk"
for i in range(len(s)):
    if (s[i] >= s[i-1]):
        string1 += s[i]
    else:
        string1 = s[i]
    if len(string1) > len(string2):
        string2 = string1
print("Longest substring in alphabetical order is: " + string2)