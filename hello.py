class Coder():
    def __init__(self):
        self.num1=int(input("num1 :"))
        self.num2=int(input("num2 :"))

class Coder2(Coder):
    def __init__(self):
        super().__init__()
    def adder(self):
        self.sum = self.num1+self.num2
        return self.sum
    
cd=Coder2()
resultforsum = cd.adder()
print("sum is :",resultforsum)