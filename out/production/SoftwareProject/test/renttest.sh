#!/bin/bash
i=0 #Counts test number
#This test tests if the program can update a rental as rented
for FILE in "Input/rent"/*.txt; do #Loop through each file
i=$(( i + 1 )) #Increment test count
echo "RENT TEST "${i}" COMPLETE"
cd ../ #Navigate to parent folder to run our Java test
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/rent/rent_out"${i}".txt"#Run our program
cat "dailyTransactions.txt" > "test/Output/rent/rent_dailytransaction"${i} #Send output file to test txt file
cd test #Return back to test folder to run next test
done

