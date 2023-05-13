year = int(input())
if year in [1996, 1997, 2000, 2007, 2008, 2013, 2018] : print("SPbSU")
else : print(["PetrSU, ITMO", "ITMO"][year != 2006])
