#!/bin/bash
declare -a arr=("frontend1.txt" "frontend2.txt" "frontend3.txt")
for DAY in {1..7}
mkdir "Day${DAY}" #Create a directory to store a transaction files for each day
cd ../../ #Navigating to folder containing our main program
for FILE in "${arr[@]}" #Copy transaction files to each Day folder
java otbnb.java rentals.txt users.txt dailyTransactions.txt < $FILE #Run our program
cp dailytransactions.txt "test/dailyuse/Day"${DAY}".txt" #Copy the transaction file to a folder marked by each day
done
cd "test/dailyuse/Day"${DAY}".txt" #Navigate to each Day's folder
touch mergeddailytransaction.txt #create a new txt file to store the merged files.
cat *.txt >> mergedtransactions.txt #concats all files to the merged file txt file
java BackendStub.java mergedtransactions.txt #run our back end stub using the marged transaction file as input
cd ../ #Navigate out to dailyuse folder to repeat loop with the next day
done


