if __name__ == "__main__" :
    typing_tech = {
        "fdsajkl;" : "in-out",
        "jkl;fdsa" : "in-out",
        "asdf;lkj" : "out-in",
        ";lkjasdf" : "out-in",
        "asdfjkl;" : "stairs",
        ";lkjfdsa" : "reverse",
    }
    S = input()
    print(typing_tech[S] if S in typing_tech.keys() else "molu")
