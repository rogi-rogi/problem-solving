from sys import stdin
input = stdin.readline

digit = "0123456789"

def J(message) :
    return message[1:] + message[0]

def C(message) :
    return message[-1] + message[:-1]
    
def E(message) :
    message_size = len(message)
    if message_size == 1 : return message
    if message_size % 2 :
        return message[((message_size + 1)//2):] + message[message_size//2] + message[:(message_size // 2)]
    else :
        return message[message_size//2:] + message[:message_size//2]
    
def A(message) :
    return message[::-1]
    
def P(message) :
    string = list(message)
    for idx, char in enumerate(message) :
        if char.isdigit() :
            string[idx] = digit[(digit.find(char) + 1) % 10]
    return ''.join(string)
    
def M(message) :
    string = list(message)
    for idx, char in enumerate(message) :
        if char.isdigit() :
            string[idx] = digit[(digit.find(char) - 1) % 10]
    return ''.join(string)
    
decoding = {
    'J' : C,
    'C' : J,
    'E' : E,
    'A' : A,
    'P' : M,
    'M' : P
}

for _ in range(int(input())) :
    encode = input().rstrip()
    message = input().rstrip()
    for cmd in encode[::-1] :
        message = decoding[cmd](message)
    print(message)
