#!/bin/bash
declare -a arr=("frontend1.txt" "frontend2.txt" "frontend3.txt")
cd ../../ #Navigating to our folder containing our program
for FILE in "${arr[@]}"
java otbnb.java rentals.txt users.txt dailyTransactions.txt < $FILE #Run our program
cp dailytransactions.txt "test/Output/dailyuse/dailytransaction"${FILE}".txt" #Copy the transaction file
done
cd test/dailyuse #Navigate to our daily use folder
touch mergeddailytransaction.txt #create a new txt file to store the merged files.
cat *.txt >> mergedtransactions.txt #concats all files to the merged file txt file
cd test/dailyuse #Navigate back into our directory
java BackendStub.java mergedtransactions.txt #run our back end stub using the marged transaction file as input

