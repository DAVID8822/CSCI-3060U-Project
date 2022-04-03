#!/bin/bash
#This test compares the expected output of login to the actual output
for i in {1..4}; do #Loops through each file
echo "testing expected login and output login $i"
diff expectedOutputs/login/login_dailytransaction$i output/login/login_dailytransaction$i #Comparing the daily transaction output to expected daily transaction
diff expectedOutputs/login/login_out$i.txt output/login/login_out$i.txt #Comparing the output files to expected output
done