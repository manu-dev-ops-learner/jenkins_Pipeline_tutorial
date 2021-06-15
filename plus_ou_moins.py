#Import
import random
#import sys

#Function
def plus_ou_moins():

    #User and Computer choices
    user_number = int(input("Entrez un chiffre entre 0 et 9 : "))
    random_number = random.randint(0,9)

    #Compare
    while (user_number != random_number):
        user_number = int(input("Une autre chance, entrez un chiffre entre 0 et 9 : "))

    if (user_number==random_number) :
        print ('Bravo vous avez vu juste !', "\N{winking face}")
    #else :
        #print("Nul, l'ordi a choisi", random_number)
    
#print(sys.version)

#Function call
plus_ou_moins()
    
