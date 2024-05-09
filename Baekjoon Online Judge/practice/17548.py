if __name__ == '__main__':
    msg = input()
    if msg == "Later!":
        print("Alligator!")
    else:
        print(msg[:-1] + msg[1:-1] + msg[-1])
