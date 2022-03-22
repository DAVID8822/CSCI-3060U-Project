#!/bin/bash
i=0
for FILE in "Input/login"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "LOGIN TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/login/login_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/login/login_dailytransaction"${i} 
cd test
done

