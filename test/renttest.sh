#!/bin/bash
i=0
for FILE in "Input/rent"/*.txt; do #Loop through each file
i=$(( i + 1 ))
echo "RENT TEST "${i}" COMPLETE"
cd ../
java otbnb.java rentals.txt users.txt dailyTransactions.txt < "test/"$FILE > "test/Output/rent/rent_out"${i}".txt"
cat "dailyTransactions.txt" > "test/Output/rent/rent_dailytransaction"${i} 
cd test
done

