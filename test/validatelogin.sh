#!/bin/bash
for i in {1..4}; do
echo "testing expected login and output login $i"
diff expectedOutputs/login/login_dailytransaction$i output/login/login_dailytransaction$i
diff expectedOutputs/login/login_out$i.txt output/login/login_out$i.txt
done